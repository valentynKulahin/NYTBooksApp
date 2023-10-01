package com.example.network.model.full_overview


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class FullOverviewNetworkModel(
    @SerializedName("copyright")
    @Expose
    val copyright: String? = null,
    @SerializedName("num_results")
    @Expose
    val numResults: Int? = null,
    @SerializedName("results")
    @Expose
    val resultsNetworkModel: ResultsNetworkModel = ResultsNetworkModel(),
    @SerializedName("status")
    @Expose
    val status: String? = null
)