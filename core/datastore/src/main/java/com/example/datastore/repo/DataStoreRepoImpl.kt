package com.example.datastore.repo

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.datastore.PreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepoImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepo {

    override suspend fun getToken(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                // dataStore.data throws an IOException when an error is encountered when reading data
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[PreferencesKey.token] ?: ""
            }
    }

    override suspend fun updateToken(token: String) {
        dataStore.edit { it[PreferencesKey.token] = token }
    }

}