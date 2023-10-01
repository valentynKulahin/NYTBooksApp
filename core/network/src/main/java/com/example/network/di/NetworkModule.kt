package com.example.network.di

import com.example.network.api.BookApi
import com.example.network.repo.NYTNetworkRepo
import com.example.network.repo.NYTNetworkRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun NYTNetworkRepo(
        bookApi: BookApi
    ): NYTNetworkRepo {
        return NYTNetworkRepoImpl(bookApi = bookApi)
    }

}