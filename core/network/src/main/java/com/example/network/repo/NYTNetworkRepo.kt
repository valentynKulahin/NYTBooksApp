package com.example.network.repo

import com.example.common.ApiResult
import com.example.common.model.ApiKeyModel
import com.example.common.model.CategoryModel

interface NYTNetworkRepo {

    suspend fun getFullOverviewRepo(apiKeyModel: ApiKeyModel): ApiResult

    suspend fun getAllCategories(apiKeyModel: ApiKeyModel): ApiResult

}