package com.example.data.repo

import android.util.Log
import com.example.common.ApiResult
import com.example.common.model.ApiKeyModel
import com.example.data.mapToData
import com.example.data.mapToRoom
import com.example.data.model.category.CategoriesDataModel
import com.example.data.model.full_overview.FullOverviewDataModel
import com.example.data.model.full_overview.ListsDataModel
import com.example.data.util.NetworkMonitor
import com.example.data.util.NetworkStatus
import com.example.database.dao.CategoriesDao
import com.example.database.dao.FullOverviewDao
import com.example.datastore.repo.DataStoreRepo
import com.example.network.model.category.CategoriesNetworkModel
import com.example.network.model.full_overview.FullOverviewNetworkModel
import com.example.network.repo.NYTNetworkRepo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NYTDataRepoImpl @Inject constructor(
    private val networkMonitor: NetworkMonitor,
    private val nytNetworkRepo: NYTNetworkRepo,
    private val dataStoreRepo: DataStoreRepo,
    private val fullOverviewDao: FullOverviewDao,
    private val categoriesDao: CategoriesDao
) : NYTDataRepo {

    override suspend fun getFullOverviewDataRepo(): FullOverviewDataModel {
        when (networkMonitor.networkStatus.first()) {
            is NetworkStatus.Connected -> {
                Log.d("TAG", "getFullOverviewDataRepo: CONNECTED")
                val result = nytNetworkRepo.getFullOverviewRepo(
                    apiKeyModel = ApiKeyModel(
                        dataStoreRepo.getToken().first().toString()
                    )
                )
                return when (result) {
                    is ApiResult.ApiSuccess -> {
                        val data = result.data as FullOverviewNetworkModel
                        fullOverviewDao.clearAllOverview()
                        fullOverviewDao.insertFullOverview(
                            fullOverviewRoomModel = data.mapToData().mapToRoom()
                        )
                        data.mapToData()
                    }

                    is ApiResult.ApiError -> {
                        Log.d("TAG", "getFullOverviewDataRepo: ERROR")
                        FullOverviewDataModel()
                    }

                    is ApiResult.ApiException -> {
                        Log.d("TAG", "getFullOverviewDataRepo: EXCEPTION")
                        FullOverviewDataModel()
                    }
                }
            }

            else -> {
                Log.d("TAG", "getFullOverviewDataRepo: DISCONNECTED")
                return fullOverviewDao.getAllOverview().mapToData()
            }
        }
    }

    override suspend fun getAllCategoriesDataRepo(): CategoriesDataModel {
        when (networkMonitor.networkStatus.first()) {
            is NetworkStatus.Connected -> {
                Log.d("TAG", "getFullOverviewDataRepo: CONNECTED")
                val result = nytNetworkRepo.getAllCategories(
                    apiKeyModel = ApiKeyModel(
                        dataStoreRepo.getToken().first().toString()
                    )
                )
                return when (result) {
                    is ApiResult.ApiSuccess -> {
                        val data = result.data as CategoriesNetworkModel
                        categoriesDao.clearAllCategories()
                        categoriesDao.insertAllCategories(
                            categoryRoomModel = data.mapToData().mapToRoom()
                        )
                        data.mapToData()
                    }

                    is ApiResult.ApiError -> {
                        Log.d("TAG", "getAllCategoriesDataRepo: ERROR")
                        CategoriesNetworkModel().mapToData()
                    }

                    is ApiResult.ApiException -> {
                        Log.d("TAG", "getAllCategoriesDataRepo: EXCEPTION")
                        CategoriesNetworkModel().mapToData()
                    }
                }
            }

            else -> {
                Log.d("TAG", "getFullOverviewDataRepo: DISCONNECTED")
                return categoriesDao.getAllCategories().mapToData()
            }
        }
    }

    override suspend fun getBooksFromCategory(category: String): ListsDataModel {
        val fullOverview = fullOverviewDao.getAllOverview().mapToData()
        return fullOverview.resultsDataModel.lists.find { item -> item.display_name == category }
            ?: ListsDataModel()
    }

}