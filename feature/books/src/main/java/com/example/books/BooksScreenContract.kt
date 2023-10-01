package com.example.books

import com.example.domain.model.full_overview.ListsDomainModel

data class BooksScreenContract(
    val listsDomainModel: ListsDomainModel = ListsDomainModel()
)

sealed interface BooksScreenIntent {

    data class GetBooksFromCategory(val category: String) : BooksScreenIntent

}
