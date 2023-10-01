package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetAllCategoriesUseCase
import com.example.domain.usecase.GetFullOverviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getFullOverviewUseCase: GetFullOverviewUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenContract())
    val uiState = _uiState.asStateFlow()

    init {
        reducer(intent = HomeScreenIntent.GetAllCategories)
        reducer(intent = HomeScreenIntent.GetFullOverview)
    }

    fun reducer(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.GetAllCategories -> {
                viewModelScope.launch(context = Dispatchers.IO) {
                    _uiState.update {
                        it.copy(categoriesDomainModel = getAllCategoriesUseCase.invoke())
                    }
                }
            }

            is HomeScreenIntent.GetFullOverview -> {
                viewModelScope.launch(context = Dispatchers.IO) {
                    getFullOverviewUseCase.invoke()
                }
            }
        }
    }

}