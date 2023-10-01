package com.example.domain

import com.example.data.mapToNetwork
import com.example.data.model.category.CategoriesDataModel
import com.example.data.model.category.ResultDataModel
import com.example.data.model.full_overview.BookDataModel
import com.example.data.model.full_overview.BuyLinkDataModel
import com.example.data.model.full_overview.FullOverviewDataModel
import com.example.data.model.full_overview.ListsDataModel
import com.example.data.model.full_overview.ResultsDataModel
import com.example.domain.model.category.CategoriesDomainModel
import com.example.domain.model.category.ResultDomainModel
import com.example.domain.model.full_overview.BookDomainModel
import com.example.domain.model.full_overview.BuyLinkDomainModel
import com.example.domain.model.full_overview.FullOverviewDomainModel
import com.example.domain.model.full_overview.ListsDomainModel
import com.example.domain.model.full_overview.ResultsDomainModel

//CATEGORY form data to domain
fun CategoriesDataModel.mapToDomain(): CategoriesDomainModel {
    return CategoriesDomainModel(copyright, num_results, results.mapToDomain(), status)
}

@JvmName(name = "listCDMToDomain")
fun List<ResultDataModel>.mapToDomain(): List<ResultDomainModel> {
    return mutableListOf<ResultDomainModel>().apply {
        this@mapToDomain.forEach {
            this.add(it.mapToDomain())
        }
    }
}

@JvmName(name = "CDMToDomain")
fun ResultDataModel.mapToDomain(): ResultDomainModel {
    return ResultDomainModel(
        display_name,
        list_name,
        list_name_encoded,
        newest_published_date,
        oldest_published_date,
        updated
    )
}

//FULL_OVERVIEW from domain to Data
fun FullOverviewDomainModel.mapToData(): FullOverviewDataModel {
    return FullOverviewDataModel(copyright, num_results, resultsDomainModel.mapToData(), status)
}

@JvmName(name = "RDMToData")
fun ResultsDomainModel.mapToData(): ResultsDataModel {
    return ResultsDataModel(
        bestsellers_date,
        lists.mapToData(),
        next_published_date,
        previous_published_date,
        published_date,
        published_date_description
    )
}

@JvmName(name = "listsFODMToData")
fun List<ListsDomainModel>.mapToData(): List<ListsDataModel> {
    return mutableListOf<ListsDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "FODMtoData")
fun ListsDomainModel.mapToData(): ListsDataModel {
    return ListsDataModel(
        books.mapToData(),
        display_name,
        list_id,
        list_name,
        list_name_encoded,
        updated
    )
}

@JvmName(name = "listBDMtoData")
fun List<BookDomainModel>.mapToData(): List<BookDataModel> {
    return mutableListOf<BookDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "BDMtoData")
fun BookDomainModel.mapToData(): BookDataModel {
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

@JvmName(name = "listBLDMToData")
fun List<BuyLinkDomainModel>.mapToData(): List<BuyLinkDataModel> {
    return mutableListOf<BuyLinkDataModel>().apply {
        this@mapToData.forEach {
            this.add(it.mapToData())
        }
    }
}

@JvmName(name = "BLNMToData")
fun BuyLinkDomainModel.mapToData(): BuyLinkDataModel {
    return BuyLinkDataModel(name, url)
}

//FULL OVERVIEW from data to domain
fun FullOverviewDataModel.mapToDomain(): FullOverviewDomainModel {
    return FullOverviewDomainModel(copyright, num_results, resultsDataModel.mapToDomain(), status)
}

@JvmName(name = "RDMToDomain")
fun ResultsDataModel.mapToDomain(): ResultsDomainModel {
    return ResultsDomainModel(
        bestsellers_date,
        lists.mapToDomain(),
        next_published_date,
        previous_published_date,
        published_date,
        published_date_description
    )
}

@JvmName(name = "listsFODMToDomain")
fun List<ListsDataModel>.mapToDomain(): List<ListsDomainModel> {
    return mutableListOf<ListsDomainModel>().apply {
        this@mapToDomain.forEach {
            this.add(it.mapToDomain())
        }
    }
}

@JvmName(name = "FODMtoDomain")
fun ListsDataModel.mapToDomain(): ListsDomainModel {
    return ListsDomainModel(
        books.mapToDomain(),
        display_name,
        list_id,
        list_name,
        list_name_encoded,
        updated
    )
}

@JvmName(name = "listBDMtoDomain")
fun List<BookDataModel>.mapToDomain(): List<BookDomainModel> {
    return mutableListOf<BookDomainModel>().apply {
        this@mapToDomain.forEach {
            this.add(it.mapToDomain())
        }
    }
}

@JvmName(name = "BDMtoDomain")
fun BookDataModel.mapToDomain(): BookDomainModel {
    return BookDomainModel(
        age_group,
        amazon_product_url,
        article_chapter_link,
        author,
        book_image,
        book_image_height,
        book_image_width,
        book_review_link,
        book_uri,
        buy_links.mapToDomain(),
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

@JvmName(name = "listBLDMToDomain")
fun List<BuyLinkDataModel>.mapToDomain(): List<BuyLinkDomainModel> {
    return mutableListOf<BuyLinkDomainModel>().apply {
        this@mapToDomain.forEach {
            this.add(it.mapToDomain())
        }
    }
}

@JvmName(name = "BLDMToDomain")
fun BuyLinkDataModel.mapToDomain(): BuyLinkDomainModel {
    return BuyLinkDomainModel(name, url)
}