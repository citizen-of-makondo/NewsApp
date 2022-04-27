package com.alexilinskiy.newsapp.di

import com.alexilinskiy.newsapp.BuildConfig
import com.alexilinskiy.newsapp.NewsApplication
import com.alexilinskiy.newsapp.api.GetNewsUseCase
import com.alexilinskiy.newsapp.api.NewsApi
import com.alexilinskiy.newsapp.api.repositoriy.NewsRepository
import com.alexilinskiy.newsapp.api.repositoriy.NewsRepositoryImpl
import com.alexilinskiy.newsapp.common.Constants
import com.alexilinskiy.newsapp.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val androidModule = module {
    single { androidApplication() }
    single { GetNewsUseCase(get()) }
    factory<NewsRepository> { NewsRepositoryImpl(get()) }
    factory { provideOkHttpClient() }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
    viewModel { MainViewModel(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideForecastApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
