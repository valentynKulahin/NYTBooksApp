package com.example.database.model.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoriesRoomModel(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val copyright: String? = null,
    val num_results: Int? = null,
    @ColumnInfo(name = "results") val results: List<ResultRoomModel> = emptyList(),
    val status: String? = null
)