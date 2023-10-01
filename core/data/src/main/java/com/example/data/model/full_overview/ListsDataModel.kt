package com.example.data.model.full_overview

data class ListsDataModel(
    val books: List<BookDataModel> = emptyList(),
    val display_name: String? = null,
    val list_id: Int? = null,
    val list_name: String? = null,
    val list_name_encoded: String? = null,
    val updated: String? = null
)