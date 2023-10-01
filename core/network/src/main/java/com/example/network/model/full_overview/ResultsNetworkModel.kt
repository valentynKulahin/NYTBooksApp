package com.example.network.model.full_overview


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ResultsNetworkModel(
    @SerializedName("bestsellers_date")
    @Expose
    val bestsellersDate: String? = null,
    @SerializedName("lists")
    @Expose
    val lists: List<ListsNetworkModel> = emptyList(),
    @SerializedName("next_published_date")
    @Expose
    val nextPublishedDate: String? = null,
    @SerializedName("previous_published_date")
    @Expose
    val previousPublishedDate: String? = null,
    @SerializedName("published_date")
    @Expose
    val publishedDate: String? = null,
    @SerializedName("published_date_description")
    @Expose
    val publishedDateDescription: String? = null
)