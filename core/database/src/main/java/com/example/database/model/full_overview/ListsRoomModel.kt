package com.example.database.model.full_overview

import androidx.room.ColumnInfo

data class ListsRoomModel(
    val display_name: String? = null,
    val list_id: Int? = null,
    val list_name: String? = null,
    val list_name_encoded: String? = null,
    val updated: String? = null,
    @ColumnInfo(name = "books") val books: List<BookRoomModel> = emptyList()
)