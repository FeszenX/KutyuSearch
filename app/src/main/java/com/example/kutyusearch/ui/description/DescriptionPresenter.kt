package com.example.kutyusearch.ui.description

import android.graphics.drawable.Drawable
import com.example.kutyusearch.events.EventBus
import com.example.kutyusearch.events.RxBusEvent
import com.example.kutyusearch.model.DogBreadResult
import com.example.kutyusearch.model.ImageResult
import com.example.kutyusearch.repository.network.DogAPI
import com.example.kutyusearch.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_dog_description.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.net.URL

object DescriptionPresenter : Presenter<DescriptionScreen>() {

    private lateinit var breadApi: DogAPI

    override fun attachScreen(screen: DescriptionScreen) {
        super.attachScreen(screen)

        EventBus.listen(RxBusEvent.ImageEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                screen?.setImage(it.image)
            }
    }

    fun queryBreedDetails(breadId: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        breadApi = retrofit.create(DogAPI::class.java)

        val breadCall = breadApi.getDogBread(breadId)

        breadCall.enqueue(object : Callback<DogBreadResult> {
            override fun onFailure(call: Call<DogBreadResult>, t: Throwable) {
                screen?.showError(t.message!!)
            }

            override fun onResponse(
                call: Call<DogBreadResult>,
                response: Response<DogBreadResult>
            ) {
                val bread = response.body()
                screen?.showDescription(bread!!)
            }
        })
    }

    fun queryBreedPicture(imageUrl: String?) {
        var finalImageUrl: String
        if (imageUrl != null) {
            finalImageUrl = imageUrl
        } else {
            finalImageUrl = "https://cataas.com/cat"
        }
        Thread {
            val image = URL(finalImageUrl)
            val stream = image.content
            val drawable = Drawable.createFromStream(stream as InputStream, null)
            EventBus.publish(RxBusEvent.ImageEvent(drawable))
        }.start()
    }
}