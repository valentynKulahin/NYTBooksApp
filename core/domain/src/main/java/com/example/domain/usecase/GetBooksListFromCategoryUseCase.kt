package com.example.domain.usecase

import com.example.data.repo.NYTDataRepo
import com.example.domain.mapToDomain
import com.example.domain.model.full_overview.ListsDomainModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetBooksListFromCategoryUseCase @Inject constructor(
    private val nytDataRepo: NYTDataRepo
) {

    suspend operator fun invoke(category: String): ListsDomainModel {
        return nytDataRepo.getBooksFromCategory(category = category).mapToDomain()
    }

}