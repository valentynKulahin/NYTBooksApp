package com.example.network.api

import com.example.network.model.category.CategoriesNetworkModel
import com.example.network.model.full_overview.FullOverviewNetworkModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookApi {

    @Headers("Content-Type: application/json")
    @GET(value = "lists/full-overview")
    fun getFullOverview(@Query("api-key") apiKey: String): Call<FullOverviewNetworkModel>

    @Headers("Content-Type: application/json")
    @GET(value = "lists/names")
    fun getAllCategories(@Query("api-key") apiKey: String): Call<CategoriesNetworkModel>

}