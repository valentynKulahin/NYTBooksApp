package com.example.network.model.full_overview


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class BookNetworkModel(
    @SerializedName("age_group")
    @Expose
    val ageGroup: String? = null,
    @SerializedName("amazon_product_url")
    @Expose
    val amazonProductUrl: String? = null,
    @SerializedName("article_chapter_link")
    @Expose
    val articleChapterLink: String? = null,
    @SerializedName("author")
    @Expose
    val author: String? = null,
    @SerializedName("book_image")
    @Expose
    val bookImage: String? = null,
    @SerializedName("book_image_height")
    @Expose
    val bookImageHeight: Int? = null,
    @SerializedName("book_image_width")
    @Expose
    val bookImageWidth: Int? = null,
    @SerializedName("book_review_link")
    @Expose
    val bookReviewLink: String? = null,
    @SerializedName("book_uri")
    @Expose
    val bookUri: String? = null,
    @SerializedName("buy_links")
    @Expose
    val buyLinkNetworkModels: List<BuyLinkNetworkModel> = emptyList(),
    @SerializedName("contributor")
    @Expose
    val contributor: String? = null,
    @SerializedName("contributor_note")
    @Expose
    val contributorNote: String? = null,
    @SerializedName("created_date")
    @Expose
    val createdDate: String? = null,
    @SerializedName("description")
    @Expose
    val description: String? = null,
    @SerializedName("first_chapter_link")
    @Expose
    val firstChapterLink: String? = null,
    @SerializedName("price")
    @Expose
    val price: String? = null,
    @SerializedName("primary_isbn10")
    @Expose
    val primaryIsbn10: String? = null,
    @SerializedName("primary_isbn13")
    @Expose
    val primaryIsbn13: String? = null,
    @SerializedName("publisher")
    @Expose
    val publisher: String? = null,
    @SerializedName("rank")
    @Expose
    val rank: Int? = null,
    @SerializedName("rank_last_week")
    @Expose
    val rankLastWeek: Int? = null,
    @SerializedName("sunday_review_link")
    @Expose
    val sundayReviewLink: String? = null,
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("updated_date")
    @Expose
    val updatedDate: String? = null,
    @SerializedName("weeks_on_list")
    @Expose
    val weeksOnList: Int? = null
)