package com.example.database.model.full_overview

import androidx.room.ColumnInfo

data class ResultsRoomModel(
    val bestsellers_date: String? = null,
    val next_published_date: String? = null,
    val previous_published_date: String? = null,
    val published_date: String? = null,
    val published_date_description: String? = null,
    @ColumnInfo(name = "lists") val lists: List<ListsRoomModel> = emptyList(),
)