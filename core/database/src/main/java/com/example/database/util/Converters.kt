package com.example.database.util

import androidx.room.TypeConverter
import com.example.database.model.category.ResultRoomModel
import com.example.database.model.full_overview.ListsRoomModel
import com.google.gson.Gson

class Converters {

    //categories
    @TypeConverter
    fun listCategoryToJson(value: List<ResultRoomModel>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToListCategory(value: String) =
        Gson().fromJson(value, Array<ResultRoomModel>::class.java).toList()

    //lists
    @TypeConverter
    fun listsToJson(value: List<ListsRoomModel>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToLists(value: String) =
        Gson().fromJson(value, Array<ListsRoomModel>::class.java).toList()




}