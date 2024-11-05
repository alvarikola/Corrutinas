package com.example.corrutinas

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val URL = "https://superheroapi.com/"
    private const val URL1 = "https://jsonplaceholder.typicode.com/"


    private val retrofit =
        Retrofit
            .Builder()
            .baseUrl(URL1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInstance():ApiServiceJsonPlaceholder{
        return retrofit.create(ApiServiceJsonPlaceholder::class.java)
    }
}