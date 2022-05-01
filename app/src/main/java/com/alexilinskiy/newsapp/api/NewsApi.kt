package com.alexilinskiy.newsapp.api

import com.alexilinskiy.newsapp.data.NewsResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("1/news")
    suspend fun getLatestNews(
        @Query("apikey") apiKey: String,
        @Query("language") language: String
    ): NewsResult
}