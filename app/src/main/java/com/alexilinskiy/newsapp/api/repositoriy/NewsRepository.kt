package com.alexilinskiy.newsapp.api.repositoriy

import com.alexilinskiy.newsapp.data.Results

interface NewsRepository {
    suspend fun getNewsList(apiKey: String): Results
}