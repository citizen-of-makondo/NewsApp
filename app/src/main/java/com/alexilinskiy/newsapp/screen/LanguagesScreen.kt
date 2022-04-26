package com.alexilinskiy.newsapp.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexilinskiy.newsapp.mocks.Languages
import kotlinx.coroutines.launch

@Composable
fun LanguagesScreen() {
    val languages = Languages.values().toList()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val schooseLanguage = remember {
        mutableStateOf("")
    }
    val onLanguageClick: (String) -> Unit = {
        schooseLanguage.value = it
    }
    val clickButton: (String) -> Unit = {
        scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(schooseLanguage.value)
        }
    }
    Scaffold(scaffoldState = scaffoldState) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderItemLanguagesScreen()
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                ) {
                    LanguagesList(languages, onLanguageClick)
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .padding(bottom = 18.dp)
                    ) {
                        ChooseLanguageButton(clickButton)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LanguagesScreenPreview() {
    LanguagesScreen()
}

@Composable
fun HeaderItemLanguagesScreen() {
    Text(
        text = "Welcome. Choose your languages",
        modifier = Modifier
            .padding(bottom = 16.dp),
        fontSize = 16.sp
    )
}

@Preview
@Composable
fun HeaderItemLanguagesScreenPreview() {
    HeaderItemLanguagesScreen()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LanguagesList(
    languages: List<Languages>,
    onLanguageClick: (String) -> Unit
) {
    val state = rememberLazyListState()

    LazyColumn(
        state = state,
        contentPadding = (PaddingValues(start = 16.dp, end = 12.dp, bottom = 64.dp))
    ) {
        items(languages) { item ->
            Surface(
                modifier = Modifier.clickable {
                    onLanguageClick(item.name)
                }
            ) {
                LanguageItem(item, onClickItem = onLanguageClick)
            }
        }
    }
}

@Preview
@Composable
fun LanguagesListPreview() {
    LanguagesList(Languages.values().toList().take(5), onLanguageClick = {})
}

@Composable
fun LanguageItem(
    item: Languages,
    modifier: Modifier = Modifier,
    onClickItem: (String) -> Unit = {}
) {
    var languageItemState: LanguageItemState by remember { mutableStateOf(LanguageItemState.IDLE) }

    val colorItem: Color by animateColorAsState(targetValue =
        if (languageItemState == LanguageItemState.IDLE)
            Color.White
        else
            Color.Yellow
    )

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        border = BorderStroke(1.dp, color = Color.LightGray),
    ) {
        Text(text = item.name,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                .background(colorItem)
                .clickable {
                    languageItemState =
                        if (languageItemState == LanguageItemState.PRESSED) {
                            onClickItem.invoke(item.name)
                            LanguageItemState.IDLE
                        } else {
                            LanguageItemState.PRESSED
                        }
                })
    }
}

@Composable
fun ChooseLanguageButton(clickButton: (String) -> Unit) {
    Button(
        onClick = {
            clickButton
        }
    ) {
        Text(
            text = "Choose language"
        )
    }
}


enum class LanguageItemState {
    IDLE,
    PRESSED
}