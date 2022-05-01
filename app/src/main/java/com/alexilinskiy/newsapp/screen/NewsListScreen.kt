package com.alexilinskiy.newsapp.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexilinskiy.newsapp.data.Result
import com.alexilinskiy.newsapp.viewmodel.MainViewModel
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.getViewModel

@Composable
fun NewsListScreen(navController: NavController) {
    val viewModel = getViewModel<MainViewModel>()
    val newsState = viewModel.state.value.news
    val list = newsState?.results?.take(10)
    val context = LocalContext.current

    val click = {
        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
        ) {
            items(list.orEmpty()) { item ->
                NewsItem(newsItem = item, navController)
            }
        }
    }
}

@Composable
fun NewsItem(newsItem: Result, onItemCLick: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onItemCLick.navigate("item") }
    ) {
        GlideImage(
            imageModel = newsItem.imageUrl,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .background(color = Color.Black)
        ) {
            Text(
                text = newsItem.title,
                modifier = Modifier
                    .padding(10.dp),
                color = Color.White
            )

        }
    }

}
