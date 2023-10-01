package com.example.network.model.category


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ResultNetworkModel(
    @SerializedName("display_name")
    @Expose
    val displayName: String? = null,
    @SerializedName("list_name")
    @Expose
    val listName: String? = null,
    @SerializedName("list_name_encoded")
    @Expose
    val listNameEncoded: String? = null,
    @SerializedName("newest_published_date")
    @Expose
    val newestPublishedDate: String? = null,
    @SerializedName("oldest_published_date")
    @Expose
    val oldestPublishedDate: String? = null,
    @SerializedName("updated")
    @Expose
    val updated: String? = null
)