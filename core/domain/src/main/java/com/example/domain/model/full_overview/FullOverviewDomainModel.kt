package com.example.domain.model.full_overview

data class FullOverviewDomainModel(
    val copyright: String? = null,
    val num_results: Int? = null,
    val resultsDomainModel: ResultsDomainModel = ResultsDomainModel(),
    val status: String? = null
)