package com.alexilinskiy.newsapp.routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexilinskiy.newsapp.screen.LanguagesScreen
import com.alexilinskiy.newsapp.screen.NewsListScreen

@Composable
fun CustomNavController(): NavHostController {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = "news_list") {
        composable("news_list") { NewsListScreen(controller) }
        composable("item") { LanguagesScreen() }
    }

    return controller
}
