package com.example.domain.usecase

import com.example.data.repo.NYTDataRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFullOverviewUseCase @Inject constructor(
    private val nytDataRepo: NYTDataRepo
) {

    suspend operator fun invoke() {
        nytDataRepo.getFullOverviewDataRepo()
    }

}