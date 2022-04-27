package com.alexilinskiy.newsapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexilinskiy.newsapp.data.NewsItem
import com.alexilinskiy.newsapp.viewmodel.MainViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NewsListScreen() {
    val viewModel = getViewModel<MainViewModel>()
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.news?.newsItems.orEmpty()) { newsItem ->
                NewsItem(newsItem = newsItem, onItemCLick = {})
            }
        }
    }
}

@Composable
fun NewsItem(newsItem: NewsItem, onItemCLick: (NewsItem) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemCLick }
        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
    ) {
        Text(text = newsItem.title)
        Text(text = newsItem.keywords.toString())
    }
}