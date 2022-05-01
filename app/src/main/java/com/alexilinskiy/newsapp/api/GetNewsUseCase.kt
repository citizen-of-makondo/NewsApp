package com.alexilinskiy.newsapp.api

import com.alexilinskiy.newsapp.api.repositoriy.NewsRepository
import com.alexilinskiy.newsapp.common.Resource
import com.alexilinskiy.newsapp.data.NewsResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsUseCase (
    private val repository: NewsRepository
) {

    operator fun invoke(apiKey: String): Flow<Resource<NewsResult>> = flow {
        try {
            emit(Resource.Loading<NewsResult>())
            val newsList = repository.getNewsList(apiKey)
            emit(Resource.Success<NewsResult>(newsList))
        } catch (e: Exception) {
            emit(Resource.Error<NewsResult>(message = e.localizedMessage ?: ""))
        }
    }
}