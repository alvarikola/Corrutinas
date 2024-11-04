package com.example.corrutinas

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/7006bfa327a198556f6df22d15090337/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperHeroDataResponse>
}


data class SuperHeroDataResponse(@SerializedName("response") val response: String)