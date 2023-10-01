package com.example.data.di

import com.example.data.repo.NYTDataRepo
import com.example.data.repo.NYTDataRepoImpl
import com.example.data.util.NetworkMonitor
import com.example.database.dao.CategoriesDao
import com.example.database.dao.FullOverviewDao
import com.example.datastore.repo.DataStoreRepo
import com.example.network.repo.NYTNetworkRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun NYTDataRepo(
        networkMonitor: NetworkMonitor,
        nytNetworkRepo: NYTNetworkRepo,
        dataStoreRepo: DataStoreRepo,
        fullOverviewDao: FullOverviewDao,
        categoriesDao: CategoriesDao
    ): NYTDataRepo {
        return NYTDataRepoImpl(
            networkMonitor,
            nytNetworkRepo,
            dataStoreRepo,
            fullOverviewDao,
            categoriesDao
        )
    }

}