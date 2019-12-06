package com.wahdanz.pixabay.data.remote

import com.wahdanz.pixabay.data.remote.model.PixabayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixbayApiInterface {

    @GET("/api/?")
    suspend fun getImages(
        @Query(value = "key") key: String,
        @Query(value = "q") q: String,
        @Query(value = "per_page") per_page: Int,
        @Query(value = "page") page: Int
    ): Response<PixabayResponse>
}