package com.alexilinskiy.newsapp.data

data class Results(
    val nextPage: Int,
    val newsItems: List<NewsItem>,
    val status: String,
    val totalResults: Int
)