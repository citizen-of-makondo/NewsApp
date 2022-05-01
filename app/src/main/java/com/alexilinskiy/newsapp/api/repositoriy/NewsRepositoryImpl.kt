package com.alexilinskiy.newsapp.api.repositoriy

import com.alexilinskiy.newsapp.api.NewsApi
import com.alexilinskiy.newsapp.data.NewsResult

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getNewsList(apiKey: String): NewsResult =
        newsApi.getLatestNews(apiKey, "ru")

}
