package com.example.data.model.category

data class CategoriesDataModel(
    val copyright: String? = null,
    val num_results: Int? = null,
    val results: List<ResultDataModel> = emptyList(),
    val status: String? = null
)