package com.alexilinskiy.newsapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexilinskiy.newsapp.api.GetNewsUseCase
import com.alexilinskiy.newsapp.common.Constants
import com.alexilinskiy.newsapp.common.Resource
import com.alexilinskiy.newsapp.data.NewsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel (
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state

    init {
        getNews()
    }

    private fun getNews() {
        getNewsUseCase.invoke(Constants.API_KEY).onEach { result ->
            when (result) {
                is Resource.Error -> _state.value = NewsState(error = result.message ?: "")
                is Resource.Loading -> _state.value = NewsState(isLoading = true)
                is Resource.Success -> _state.value = NewsState(news = result.data)
            }
        }.launchIn(viewModelScope)
    }
}