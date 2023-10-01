package com.example.network.model.full_overview


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ListsNetworkModel(
    @SerializedName("books")
    @Expose
    val bookNetworkModels: List<BookNetworkModel> = emptyList(),
    @SerializedName("display_name")
    @Expose
    val displayName: String? = null,
    @SerializedName("list_id")
    @Expose
    val listId: Int? = null,
    @SerializedName("list_image")
    @Expose
    val listImage: Any? = null,
    @SerializedName("list_image_height")
    @Expose
    val listImageHeight: Any? = null,
    @SerializedName("list_image_width")
    @Expose
    val listImageWidth: Any? = null,
    @SerializedName("list_name")
    @Expose
    val listName: String? = null,
    @SerializedName("list_name_encoded")
    @Expose
    val listNameEncoded: String? = null,
    @SerializedName("updated")
    @Expose
    val updated: String? = null
)