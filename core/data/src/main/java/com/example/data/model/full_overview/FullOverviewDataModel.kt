package com.example.data.model.full_overview

data class FullOverviewDataModel(
    val copyright: String? = null,
    val num_results: Int? = null,
    val resultsDataModel: ResultsDataModel = ResultsDataModel(),
    val status: String? = null
)