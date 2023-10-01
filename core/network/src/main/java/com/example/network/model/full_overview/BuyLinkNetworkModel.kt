package com.example.network.model.full_overview


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class BuyLinkNetworkModel(
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("url")
    @Expose
    val url: String? = null
)