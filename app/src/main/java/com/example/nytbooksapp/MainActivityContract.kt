package com.example.nytbooksapp

import com.example.data.util.NetworkStatus

data class MainActivityContract(
    val networkStatus: NetworkStatus = NetworkStatus.Unknown,
    val category: String? = null
)