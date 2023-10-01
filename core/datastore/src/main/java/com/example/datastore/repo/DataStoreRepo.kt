package com.example.datastore.repo

import kotlinx.coroutines.flow.Flow

interface DataStoreRepo {

    suspend fun updateToken(token: String)

    suspend fun getToken(): Flow<String>

}