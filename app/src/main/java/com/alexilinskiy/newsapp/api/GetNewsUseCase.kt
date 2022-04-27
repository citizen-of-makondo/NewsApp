package com.alexilinskiy.newsapp.api

import com.alexilinskiy.newsapp.api.repositoriy.NewsRepository
import com.alexilinskiy.newsapp.common.Resource
import com.alexilinskiy.newsapp.data.Results
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsUseCase (
    private val repository: NewsRepository
) {

    operator fun invoke(apiKey: String): Flow<Resource<Results>> = flow {
        try {
            emit(Resource.Loading<Results>())
            val newsList = repository.getNewsList(apiKey)
            emit(Resource.Success<Results>(newsList))
        } catch (e: Exception) {
            emit(Resource.Error<Results>(message = e.localizedMessage ?: ""))
        }
    }
}