package com.example.database.di

import com.example.database.NYTDatabase
import com.example.database.dao.CategoriesDao
import com.example.database.dao.FullOverviewDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesBooksDao(
        database: NYTDatabase
    ): FullOverviewDao = database.fullOverviewDao()

    @Provides
    fun providesCategoryDao(
        database: NYTDatabase
    ): CategoriesDao = database.categoriesDao()

}
