package com.example.kutyusearch.utils

import com.example.kutyusearch.model.DogBreadResult
import com.example.kutyusearch.model.ImageResult

//inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)!!
//
//inline fun <reified T : Any> mock(s: MockSettings): T = Mockito.mock(T::class.java, s)!!
//
//inline fun <reified T : Any> argumentCaptor(): ArgumentCaptor<T> = ArgumentCaptor.forClass(T::class.java)
//inline fun <reified T : Any> nullableArgumentCaptor(): ArgumentCaptor<T?> = ArgumentCaptor.forClass(T::class.java)
//inline fun <reified T : Any> capture(captor: ArgumentCaptor<T>): T = captor.capture()

fun getDogBreadResult(): DogBreadResult {
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