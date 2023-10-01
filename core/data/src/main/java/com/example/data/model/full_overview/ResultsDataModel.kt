package com.example.data.model.full_overview

data class ResultsDataModel(
    val bestsellers_date: String? = null,
    val lists: List<ListsDataModel> = emptyList(),
    val next_published_date: String? = null,
    val previous_published_date: String? = null,
    val published_date: String? = null,
    val published_date_description: String? = null
)