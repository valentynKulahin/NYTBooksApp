package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.model.full_overview.FullOverviewRoomModel

@Dao
interface FullOverviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFullOverview(fullOverviewRoomModel: FullOverviewRoomModel)

    @Query(value = "SELECT * FROM overview")
    suspend fun getAllOverview(): FullOverviewRoomModel

    @Query(value = "DELETE FROM overview")
    suspend fun clearAllOverview()

}