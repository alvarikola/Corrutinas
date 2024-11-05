package com.example.corrutinas

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceJsonPlaceholder {

    @GET("/albums")
    suspend fun getAlbums(): Response<List<AlbumsDataResponse>>
}


data class AlbumsDataResponse(
    @SerializedName("userID") val userID: String,
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,

)
