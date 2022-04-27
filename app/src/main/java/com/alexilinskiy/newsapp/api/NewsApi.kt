package com.alexilinskiy.newsapp.api

import com.alexilinskiy.newsapp.data.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("1/news")
    suspend fun getLatestNews(@Query("apikey") apiKey: String): Results
}