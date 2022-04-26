package com.alexilinskiy.newsapp.data

data class NewsState(
    val isLoading: Boolean = false,
    val news: Results? = null,
    val error: String = ""
)
