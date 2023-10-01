package com.example.domain.model.full_overview

data class ResultsDomainModel(
    val bestsellers_date: String? = null,
    val lists: List<ListsDomainModel> = emptyList(),
    val next_published_date: String? = null,
    val previous_published_date: String? = null,
    val published_date: String? = null,
    val published_date_description: String? = null
)