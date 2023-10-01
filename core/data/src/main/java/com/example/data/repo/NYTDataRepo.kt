package com.example.data.repo

import com.example.data.model.category.CategoriesDataModel
import com.example.data.model.full_overview.FullOverviewDataModel
import com.example.data.model.full_overview.ListsDataModel

interface NYTDataRepo {

    suspend fun getFullOverviewDataRepo(): FullOverviewDataModel

    suspend fun getAllCategoriesDataRepo(): CategoriesDataModel

    suspend fun getBooksFromCategory(category: String): ListsDataModel

}