package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.dao.CategoriesDao
import com.example.database.dao.FullOverviewDao
import com.example.database.model.category.CategoriesRoomModel
import com.example.database.model.full_overview.FullOverviewRoomModel
import com.example.database.util.Converters

@Database(
    entities =
    [
        FullOverviewRoomModel::class,
        CategoriesRoomModel::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NYTDatabase : RoomDatabase() {

    abstract fun fullOverviewDao() : FullOverviewDao

    abstract fun categoriesDao() : CategoriesDao

}