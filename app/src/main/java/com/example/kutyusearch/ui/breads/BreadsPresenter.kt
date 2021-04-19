package com.example.kutyusearch.ui.breads

import android.content.Context
import com.example.kutyusearch.events.EventBus
import com.example.kutyusearch.events.RxBusEvent
import com.example.kutyusearch.model.DogBread
import com.example.kutyusearch.model.DogBreadResult
import com.example.kutyusearch.repository.database.AppDatabase
import com.example.kutyusearch.repository.network.DogAPI
import com.example.kutyusearch.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BreadsPresenter : Presenter<BreadsScreen?>() {

    override fun attachScreen(screen: BreadsScreen?) {
        super.attachScreen(screen)

        EventBus.listen(RxBusEvent.BreadsEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                screen?.showBreads(it.breadsList)
            }
    }


    override fun detachScreen() {
        super.detachScreen()
    }


    fun queryBreads(context: Context) {
        Thread {
            val breadsList = getStoredBreadList(context)

            if (breadsList.isNotEmpty()) {
                showBreadList(breadsList)
            } else {
                getBreadListFromDogApi(context)
            }
        }.start()
    }

    private fun getStoredBreadList(context: Context): List<DogBread> {
        return AppDatabase.getInstance(context).dogBreadDao().getAllBreads()
    }

    private fun showBreadList(breadsList: List<DogBread>) {
        EventBus.publish(RxBusEvent.BreadsEvent(breadsList))
    }

    private fun getBreadListFromDogApi(context: Context) {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val breadApi = retrofit.create(DogAPI::class.java)

        val breadCall = breadApi.getDogBreadList()

        breadCall.enqueue(object : Callback<List<DogBreadResult>> {
            override fun onFailure(call: Call<List<DogBreadResult>>, t: Throwable) {
                screen?.showError(t.message!!)
            }

            override fun onResponse(
                call: Call<List<DogBreadResult>>,
                response: Response<List<DogBreadResult>>
            ) {
                val breadList = response.body()
                val showBreadList = emptyList<DogBread>()

                breadList?.forEach { bread ->
                    run {
                        val newBread = saveBread(context, bread)
                        if (newBread !== null) {
                            showBreadList.toMutableList().add(newBread)
                        }
                    }
                }

                showBreadList(showBreadList)
            }
        })
    }

    fun saveBread(context: Context, bread: DogBreadResult): DogBread? {
        if (bread.name !== null && bread.name.isNotBlank()) {
            val newBread = DogBread(null, bread.id!!, bread.name)

            Thread {
                newBread.breadId = AppDatabase
                    .getInstance(context)
                    .dogBreadDao()
                    .insertBread(newBread)
            }.start()

            return newBread
        } else {
            return null
        }
    }
}