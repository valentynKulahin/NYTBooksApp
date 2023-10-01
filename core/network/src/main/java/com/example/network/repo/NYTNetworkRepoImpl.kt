package com.example.network.repo

import com.example.common.ApiResult
import com.example.common.model.ApiKeyModel
import com.example.common.model.CategoryModel
import com.example.network.api.BookApi
import com.example.network.util.ApiHandler.handleApi
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NYTNetworkRepoImpl @Inject constructor(
    private val bookApi: BookApi
) : NYTNetworkRepo {

    override suspend fun getFullOverviewRepo(apiKeyModel: ApiKeyModel): ApiResult =
        execute { bookApi.getFullOverview(apiKey = apiKeyModel.apiKey.toString()) }

    override suspend fun getAllCategories(apiKeyModel: ApiKeyModel): ApiResult =
        execute { bookApi.getAllCategories(apiKey = apiKeyModel.apiKey.toString()) }

    private suspend fun execute(request: () -> Call<*>): ApiResult {
        return when (val response = handleApi { request.invoke().execute() }) {
            is ApiResult.ApiSuccess -> ApiResult.ApiSuccess(data = response.data)
            is ApiResult.ApiError -> ApiResult.ApiError(
                code = response.code,
                message = response.message
            )

            is ApiResult.ApiException -> ApiResult.ApiException(e = response.e)
        }
    }

}