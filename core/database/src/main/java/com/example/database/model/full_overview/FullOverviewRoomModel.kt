package com.example.database.model.full_overview

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "overview")
data class FullOverviewRoomModel(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val copyright: String? = null,
    val num_results: Int? = null,
    val status: String? = null,
    @Embedded val resultsRoomModel: ResultsRoomModel = ResultsRoomModel()
)