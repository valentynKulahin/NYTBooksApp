package com.example.nytbooksapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.util.NetworkMonitor
import com.example.data.util.NetworkStatus
import com.example.datastore.repo.DataStoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    networkMonitor: NetworkMonitor,
    private val dataStoreRepo: DataStoreRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainActivityContract())
    val uiState = _uiState.asStateFlow()

    val networkStatus: StateFlow<NetworkStatus> =
        networkMonitor.networkStatus.stateIn(
            scope = CoroutineScope(context = Dispatchers.IO),
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = NetworkStatus.Unknown
        )

    init {
        viewModelScope.launch(context = Dispatchers.IO) {
            dataStoreRepo.updateToken(token = "fBxo2A6Nm00BGRCMzKh6AhzQrHOJ877l")
        }
    }

}