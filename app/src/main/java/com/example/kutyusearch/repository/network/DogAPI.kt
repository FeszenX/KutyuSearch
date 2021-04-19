package com.example.kutyusearch.repository.network

import com.example.kutyusearch.model.DogBreadResult
import com.example.kutyusearch.model.ImageResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DogAPI {
    @Headers(
        "x-api-key: 06b414ff-ded0-47f1-a518-c3faacb752b8"
    )
    @GET("/v1/breeds")
    fun getDogBreadList(): Call<List<DogBreadResult>>

    @Headers(
        "x-api-key: 06b414ff-ded0-47f1-a518-c3faacb752b8"
    )
    @GET("/v1/breeds/{id}")
    fun getDogBread(@Path("id") id: String): Call<DogBreadResult>

    @Headers(
        "x-api-key: 06b414ff-ded0-47f1-a518-c3faacb752b8"
    )
    @GET("/v1/images/search")
    fun getDogBreadImage(@Query("breed_id") breed_id: String): Call<List<ImageResult>>
}