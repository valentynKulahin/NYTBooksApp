package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.model.category.CategoriesRoomModel

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categoryRoomModel: CategoriesRoomModel)

    @Query(value = "SELECT * FROM categories")
    suspend fun getAllCategories() : CategoriesRoomModel?

    @Query(value = "DELETE FROM categories")
    suspend fun clearAllCategories()

}