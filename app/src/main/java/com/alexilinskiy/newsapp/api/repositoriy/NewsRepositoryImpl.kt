package com.alexilinskiy.newsapp.api.repositoriy

import com.alexilinskiy.newsapp.api.NewsApi
import com.alexilinskiy.newsapp.data.Results
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getNewsList(apiKey: String): Results =
        newsApi.getLatestNews(apiKey)

}
