package com.example.domain.model.full_overview

data class ListsDomainModel(
    val books: List<BookDomainModel> = emptyList(),
    val display_name: String? = null,
    val list_id: Int? = null,
    val list_name: String? = null,
    val list_name_encoded: String? = null,
    val updated: String? = null
)