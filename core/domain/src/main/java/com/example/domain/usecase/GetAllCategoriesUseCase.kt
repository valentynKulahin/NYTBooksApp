package com.example.domain.usecase

import com.example.data.repo.NYTDataRepo
import com.example.domain.mapToDomain
import com.example.domain.model.category.CategoriesDomainModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllCategoriesUseCase @Inject constructor(
    private val nytDataRepo: NYTDataRepo
) {

    suspend operator fun invoke(): CategoriesDomainModel {
        return nytDataRepo.getAllCategoriesDataRepo().mapToDomain()
    }

}