package com.alexilinskiy.newsapp.data

data class NewsItem(
    val nextPage: Int,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)