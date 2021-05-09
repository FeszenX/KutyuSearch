package com.example.kutyusearch.mock

import com.example.kutyusearch.model.DogBreadResult
import com.example.kutyusearch.model.ImageResult
import com.example.kutyusearch.repository.network.DogAPI
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockDogApi : DogAPI {
    override fun getDogBreadList(): Call<List<DogBreadResult>> {
        val dogBreadResults = ArrayList<DogBreadResult>()

        dogBreadResults.add(getDogBreadResult())

        val call = object : Call<List<DogBreadResult>> {
            @Throws(IOException::class)
            override fun execute(): Response<List<DogBreadResult>> {
                return Response.success(dogBreadResults)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<List<DogBreadResult>> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun enqueue(callback: Callback<List<DogBreadResult>>) {
            }
        }

        return call
    }

    override fun getDogBread(id: String): Call<DogBreadResult> {
        val dogBreadResult = getDogBreadResult()

        val call = object : Call<DogBreadResult> {
            @Throws(IOException::class)
            override fun execute(): Response<DogBreadResult> {
                return Response.success(dogBreadResult)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<DogBreadResult> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun enqueue(callback: Callback<DogBreadResult>) {
            }
        }

        return call
    }

    private fun getDogBreadResult(): DogBreadResult {
        return DogBreadResult(
            "",
            0,
            0,
            0,
            "aege",
            "9 - 12",
            "Aegean",
            "Greece",
            0,
            0,
            "ozEvzdVM-",
            0,
            0,
            0,
            "Affectionate, Social, Intelligent, Playful, Active",
            "https://en.wikipedia.org/wiki/Aegean_cat",
            ImageResult(
                800,
                "ozEvzdVM-",
                "https://cdn2.thecatapi.com/images/ozEvzdVM-.jpg",
                1200
            )
        )
    }
}