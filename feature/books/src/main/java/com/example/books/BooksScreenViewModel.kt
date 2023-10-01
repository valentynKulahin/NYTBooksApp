package com.example.books

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetBooksListFromCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksScreenViewModel @Inject constructor(
    private val getBooksListFromCategoryUseCase: GetBooksListFromCategoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BooksScreenContract())
    val uiState = _uiState.asStateFlow()

    fun reducer(intent: BooksScreenIntent) {
        viewModelScope.launch(context = Dispatchers.IO) {
            when (intent) {
                is BooksScreenIntent.GetBooksFromCategory -> {
                    _uiState.update {
                        it.copy(listsDomainModel = getBooksListFromCategoryUseCase.invoke(category = intent.category))
                    }
                    Log.d("TAG", "reducer BOOKS: ${_uiState.value.listsDomainModel.books.size}")
                }
            }
        }
    }

}