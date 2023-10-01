package com.example.database.model.full_overview

import androidx.room.ColumnInfo

data class BookRoomModel(
    val age_group: String? = null,
    val amazon_product_url: String? = null,
    val article_chapter_link: String? = null,
    val author: String? = null,
    val book_image: String? = null,
    val book_image_height: Int? = null,
    val book_image_width: Int? = null,
    val book_review_link: String? = null,
    val book_uri: String? = null,
    val contributor: String? = null,
    val contributor_note: String? = null,
    val created_date: String? = null,
    val description: String? = null,
    val first_chapter_link: String? = null,
    val price: String? = null,
    val primary_isbn10: String? = null,
    val primary_isbn13: String? = null,
    val publisher: String? = null,
    val rank: Int? = null,
    val rank_last_week: Int? = null,
    val sunday_review_link: String? = null,
    val title: String? = null,
    val updated_date: String? = null,
    val weeks_on_list: Int? = null,
    @ColumnInfo(name = "buy_link") val buy_links: List<BuyLinkRoomModel> = emptyList()
)