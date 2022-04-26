package com.alexilinskiy.newsapp.di

import com.alexilinskiy.newsapp.api.GetNewsUseCase
import com.alexilinskiy.newsapp.api.NewsApi
import com.alexilinskiy.newsapp.api.repositoriy.NewsRepository
import com.alexilinskiy.newsapp.api.repositoriy.NewsRepositoryImpl
import com.alexilinskiy.newsapp.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepositoryImpl(api: NewsApi): NewsRepository {
        return NewsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(repository)
    }
}
