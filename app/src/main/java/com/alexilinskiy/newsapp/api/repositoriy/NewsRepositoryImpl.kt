package com.alexilinskiy.newsapp.api.repositoriy

import com.alexilinskiy.newsapp.api.NewsApi
import com.alexilinskiy.newsapp.data.Results

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getNewsList(apiKey: String): Results =
        newsApi.getLatestNews(apiKey)

}
