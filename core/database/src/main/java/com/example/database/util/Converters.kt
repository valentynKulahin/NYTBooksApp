package com.example.database.util

import androidx.room.TypeConverter
import com.example.database.model.category.ResultRoomModel
import com.example.database.model.full_overview.BookRoomModel
import com.example.database.model.full_overview.BuyLinkRoomModel
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

    //books
    @TypeConverter
    fun booksToJson(value: List<BookRoomModel>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToBooks(value: String) =
        Gson().fromJson(value, Array<BookRoomModel>::class.java).toList()

    //buy link
    @TypeConverter
    fun listBuyLinkToJson(value: List<BuyLinkRoomModel>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToListBuyLink(value: String) =
        Gson().fromJson(value, Array<BuyLinkRoomModel>::class.java).toList()


}