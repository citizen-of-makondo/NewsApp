package com.alexilinskiy.newsapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexilinskiy.newsapp.ui.theme.NewsAppTheme

@Composable
fun HeaderItem(
    modifier: Modifier = Modifier,
    onClickAction: () -> Unit = {}
) {

}

@Preview
@Composable
fun HeaderItemPreview() {
    NewsAppTheme {
        HeaderItem()
    }
}