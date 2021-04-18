package com.example.kutyusearch.repository.network

import com.example.kutyusearch.model.DogBreadResult
import retrofit2.Call
import retrofit2.http.GET

interface DogAPI {
    @GET("/breeds")
    fun getDogBreadList(): Call<List<DogBreadResult>>
}