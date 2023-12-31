package com.example.home

import com.example.domain.model.category.CategoriesDomainModel

data class HomeScreenContract(
    val categoriesDomainModel: CategoriesDomainModel = CategoriesDomainModel()
)

sealed interface HomeScreenIntent {
    data object GetAllCategories : HomeScreenIntent
    data object GetFullOverview : HomeScreenIntent
}