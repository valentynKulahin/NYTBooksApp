package com.example.network.model.category


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class CategoriesNetworkModel(
    @SerializedName("copyright")
    @Expose
    val copyright: String? = null,
    @SerializedName("num_results")
    @Expose
    val numResults: Int? = null,
    @SerializedName("results")
    @Expose
    val resultNetworkModels: List<ResultNetworkModel> = emptyList(),
    @SerializedName("status")
    @Expose
    val status: String? = null
)