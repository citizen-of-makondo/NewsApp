package com.alexilinskiy.newsapp.data

data class NewsResult(
    val nextPage: Int,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)