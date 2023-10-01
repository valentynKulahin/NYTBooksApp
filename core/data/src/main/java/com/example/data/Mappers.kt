package com.example.data

import com.example.data.model.category.CategoriesDataModel
import com.example.data.model.category.ResultDataModel
import com.example.data.model.full_overview.BookDataModel
import com.example.data.model.full_overview.BuyLinkDataModel
import com.example.data.model.full_overview.FullOverviewDataModel
import com.example.data.model.full_overview.ListsDataModel
import com.example.data.model.full_overview.ResultsDataModel
import com.example.database.model.category.CategoriesRoomModel
import com.example.database.model.category.ResultRoomModel
import com.example.database.model.full_overview.BookRoomModel
import com.example.database.model.full_overview.BuyLinkRoomModel
import com.example.database.model.full_overview.FullOverviewRoomModel
import com.example.database.model.full_overview.ListsRoomModel
import com.example.database.model.full_overview.ResultsRoomModel
import com.example.network.model.category.CategoriesNetworkModel
import com.example.network.model.category.ResultNetworkModel
import com.example.network.model.full_overview.BookNetworkModel
import com.example.network.model.full_overview.BuyLinkNetworkModel
import com.example.network.model.full_overview.FullOverviewNetworkModel
import com.example.network.model.full_overview.ListsNetworkModel
import com.example.network.model.full_overview.ResultsNetworkModel

//CATEGORY from Network to Data
fun CategoriesNetworkModel.mapToData(): CategoriesDataModel {
    return CategoriesDataModel(copyright, numResults, resultNetworkModels.mapToData(), status)
}

@JvmName(name = "listCNMToData")
fun List<ResultNetworkModel>.mapToData(): List<ResultDataModel> {
    return mutableListOf<ResultDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "CNMToData")
fun ResultNetworkModel.mapToData(): ResultDataModel {
    return ResultDataModel(
        displayName,
        listName,
        listNameEncoded,
        newestPublishedDate,
        oldestPublishedDate,
        updated
    )
}

//CATEGORY form data to room
fun CategoriesDataModel.mapToRoom(): CategoriesRoomModel {
    return CategoriesRoomModel(null, copyright, num_results, results.mapToRoom(), status)
}

@JvmName(name = "listCDMToRoom")
fun List<ResultDataModel>.mapToRoom(): List<ResultRoomModel> {
    return mutableListOf<ResultRoomModel>().apply {
        this@mapToRoom.forEach {
            this.add(it.mapToRoom())
        }
    }
}

@JvmName(name = "CDMToRoom")
fun ResultDataModel.mapToRoom(): ResultRoomModel {
    return ResultRoomModel(
        display_name,
        list_name,
        list_name_encoded,
        newest_published_date,
        oldest_published_date,
        updated
    )
}

//CATEGORY form room to data
fun CategoriesRoomModel.mapToData(): CategoriesDataModel {
    return CategoriesDataModel(copyright, num_results, results.mapToData(), status)
}

@JvmName(name = "listCDMToData")
fun List<ResultRoomModel>.mapToData(): List<ResultDataModel> {
    return mutableListOf<ResultDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "CDMToData")
fun ResultRoomModel.mapToData(): ResultDataModel {
    return ResultDataModel(
        display_name,
        list_name,
        list_name_encoded,
        newest_published_date,
        oldest_published_date,
        updated
    )
}

//FULL_OVERVIEW from Network to Data
fun FullOverviewNetworkModel.mapToData(): FullOverviewDataModel {
    return FullOverviewDataModel(copyright, numResults, resultsNetworkModel.mapToData(), status)
}

@JvmName(name = "RNMToData")
fun ResultsNetworkModel.mapToData(): ResultsDataModel {
    return ResultsDataModel(
        bestsellersDate,
        lists.mapToData(),
        nextPublishedDate,
        previousPublishedDate,
        publishedDate,
        publishedDateDescription
    )
}

@JvmName(name = "listsFONMToData")
fun List<ListsNetworkModel>.mapToData(): List<ListsDataModel> {
    return mutableListOf<ListsDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "FONMtoData")
fun ListsNetworkModel.mapToData(): ListsDataModel {
    return ListsDataModel(
        bookNetworkModels.mapToData(),
        displayName,
        listId,
        listName,
        listNameEncoded,
        updated
    )
}

@JvmName(name = "listBNMtoData")
fun List<BookNetworkModel>.mapToData(): List<BookDataModel> {
    return mutableListOf<BookDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "BNMtoData")
fun BookNetworkModel.mapToData(): BookDataModel {
    return BookDataModel(
        ageGroup,
        amazonProductUrl,
        articleChapterLink,
        author,
        bookImage,
        bookImageHeight,
        bookImageWidth,
        bookReviewLink,
        bookUri,
        buyLinkNetworkModels.mapToData(),
        contributor,
        contributorNote,
        createdDate,
        description,
        firstChapterLink,
        price,
        primaryIsbn10,
        primaryIsbn13,
        publisher,
        rank,
        rankLastWeek,
        sundayReviewLink,
        title,
        updatedDate,
        weeksOnList
    )
}

@JvmName(name = "listBLNMToData")
fun List<BuyLinkNetworkModel>.mapToData(): List<BuyLinkDataModel> {
    return mutableListOf<BuyLinkDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "BLNMToData")
fun BuyLinkNetworkModel.mapToData(): BuyLinkDataModel {
    return BuyLinkDataModel(name, url)
}

//FULL OVERVIEW from data to network
fun FullOverviewDataModel.mapToNetwork(): FullOverviewNetworkModel {
    return FullOverviewNetworkModel(copyright, num_results, resultsDataModel.mapToNetwork(), status)
}

@JvmName(name = "RNMToNetwork")
fun ResultsDataModel.mapToNetwork(): ResultsNetworkModel {
    return ResultsNetworkModel(
        bestsellers_date,
        lists.mapToNetwork(),
        next_published_date,
        previous_published_date,
        published_date,
        published_date_description
    )
}

@JvmName(name = "listsFONMToNetwork")
fun List<ListsDataModel>.mapToNetwork(): List<ListsNetworkModel> {
    return mutableListOf<ListsNetworkModel>().apply {
        this@mapToNetwork.forEach {
            this.add(it.mapToNetwork())
        }
    }
}

@JvmName(name = "FONMtoNetwork")
fun ListsDataModel.mapToNetwork(): ListsNetworkModel {
    return ListsNetworkModel(
        books.mapToNetwork(),
        display_name,
        list_id,
        list_name,
        list_name_encoded,
        updated
    )
}

@JvmName(name = "listBNMtoNetwork")
fun List<BookDataModel>.mapToNetwork(): List<BookNetworkModel> {
    return mutableListOf<BookNetworkModel>().apply {
        this@mapToNetwork.forEach {
            this.add(it.mapToNetwork())
        }
    }
}

@JvmName(name = "BNMtoNetwork")
fun BookDataModel.mapToNetwork(): BookNetworkModel {
    return BookNetworkModel(
        age_group,
        amazon_product_url,
        article_chapter_link,
        author,
        book_image,
        book_image_height,
        book_image_width,
        book_review_link,
        book_uri,
        buy_links.mapToNetwork(),
        contributor,
        contributor_note,
        created_date,
        description,
        first_chapter_link,
        price,
        primary_isbn10,
        primary_isbn13,
        publisher,
        rank,
        rank_last_week,
        sunday_review_link,
        title,
        updated_date,
        weeks_on_list
    )
}

@JvmName(name = "listBLNMToNetwork")
fun List<BuyLinkDataModel>.mapToNetwork(): List<BuyLinkNetworkModel> {
    return mutableListOf<BuyLinkNetworkModel>().apply {
        this@mapToNetwork.forEach {
            this.add(it.mapToNetwork())
        }
    }
}

@JvmName(name = "BLNMToNetwork")
fun BuyLinkDataModel.mapToNetwork(): BuyLinkNetworkModel {
    return BuyLinkNetworkModel(name, url)
}

//FULL_OVERVIEW from data to room
fun FullOverviewDataModel.mapToRoom(): FullOverviewRoomModel {
    return FullOverviewRoomModel(null, copyright, num_results, status, resultsDataModel.mapToRoom())
}

@JvmName(name = "RDMToRoom")
fun ResultsDataModel.mapToRoom(): ResultsRoomModel {
    return ResultsRoomModel(
        bestsellers_date,
        next_published_date,
        previous_published_date,
        published_date,
        published_date_description,
        lists.mapToRoom()
    )
}

@JvmName(name = "listsFODMToRoom")
fun List<ListsDataModel>.mapToRoom(): List<ListsRoomModel> {
    return mutableListOf<ListsRoomModel>().apply {
        this@mapToRoom.forEach {
            this.add(it.mapToRoom())
        }
    }
}

@JvmName(name = "FODMtoRoom")
fun ListsDataModel.mapToRoom(): ListsRoomModel {
    return ListsRoomModel(
        display_name,
        list_id,
        list_name,
        list_name_encoded,
        updated,
        books.mapToRoom()
    )
}

@JvmName(name = "listBDMtoRoom")
fun List<BookDataModel>.mapToRoom(): List<BookRoomModel> {
    return mutableListOf<BookRoomModel>().apply {
        this@mapToRoom.forEach {
            this.add(it.mapToRoom())
        }
    }
}

@JvmName(name = "BDMtoRoom")
fun BookDataModel.mapToRoom(): BookRoomModel {
    return BookRoomModel(
        age_group,
        amazon_product_url,
        article_chapter_link,
        author,
        book_image,
        book_image_height,
        book_image_width,
        book_review_link,
        book_uri,
        contributor,
        contributor_note,
        created_date,
        description,
        first_chapter_link,
        price,
        primary_isbn10,
        primary_isbn13,
        publisher,
        rank,
        rank_last_week,
        sunday_review_link,
        title,
        updated_date,
        weeks_on_list,
        buy_links.mapToRoom(),
    )
}

@JvmName(name = "listBLDMToRoom")
fun List<BuyLinkDataModel>.mapToRoom(): List<BuyLinkRoomModel> {
    return mutableListOf<BuyLinkRoomModel>().apply {
        this@mapToRoom.forEach {
            this.add(it.mapToRoom())
        }
    }
}

@JvmName(name = "BLNMToRoom")
fun BuyLinkDataModel.mapToRoom(): BuyLinkRoomModel {
    return BuyLinkRoomModel(name, url)
}

//FULL OVERVIEW from room to data
fun FullOverviewRoomModel.mapToData(): FullOverviewDataModel {
    return FullOverviewDataModel(copyright, num_results, resultsRoomModel.mapToData(), status)
}

@JvmName(name = "RRMToData")
fun ResultsRoomModel.mapToData(): ResultsDataModel {
    return ResultsDataModel(
        bestsellers_date,
        lists.mapToData(),
        next_published_date,
        previous_published_date,
        published_date,
        published_date_description
    )
}

@JvmName(name = "listsFORMToNetwork")
fun List<ListsRoomModel>.mapToData(): List<ListsDataModel> {
    return mutableListOf<ListsDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "FORMtoData")
fun ListsRoomModel.mapToData(): ListsDataModel {
    return ListsDataModel(
        books.mapToData(),
        display_name,
        list_id,
        list_name,
        list_name_encoded,
        updated
    )
}

@JvmName(name = "listBRMtoData")
fun List<BookRoomModel>.mapToData(): List<BookDataModel> {
    return mutableListOf<BookDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "BRMtoData")
fun BookRoomModel.mapToData(): BookDataModel {
    return BookDataModel(
        age_group,
        amazon_product_url,
        article_chapter_link,
        author,
        book_image,
        book_image_height,
        book_image_width,
        book_review_link,
        book_uri,
        buy_links.mapToData(),
        contributor,
        contributor_note,
        created_date,
        description,
        first_chapter_link,
        price,
        primary_isbn10,
        primary_isbn13,
        publisher,
        rank,
        rank_last_week,
        sunday_review_link,
        title,
        updated_date,
        weeks_on_list
    )
}

@JvmName(name = "listBLRMToData")
fun List<BuyLinkRoomModel>.mapToData(): List<BuyLinkDataModel> {
    return mutableListOf<BuyLinkDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "BLNMToData")
fun BuyLinkRoomModel.mapToData(): BuyLinkDataModel {
    return BuyLinkDataModel(name, url)
}