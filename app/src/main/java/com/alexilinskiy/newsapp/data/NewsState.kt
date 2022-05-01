package com.alexilinskiy.newsapp.data

data class NewsState(
    val isLoading: Boolean = false,
    val news: NewsResult? = null,
    val error: String = ""
)
