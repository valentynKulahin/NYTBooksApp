package com.example.domain.model.category

data class CategoriesDomainModel(
    val copyright: String? = null,
    val num_results: Int? = null,
    val results: List<ResultDomainModel> = emptyList(),
    val status: String? = null
)