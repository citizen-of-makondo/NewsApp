package com.alexilinskiy.newsapp.api.repositoriy

import com.alexilinskiy.newsapp.data.NewsResult

interface NewsRepository {
    suspend fun getNewsList(apiKey: String): NewsResult
}