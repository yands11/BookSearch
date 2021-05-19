package com.blank.booksearch.ui.common

import com.blank.booksearch.entity.Book

data class BookUiModel(
    val isbn13: String,
    val title: String,
    val subTitle: String,
    val coverImageUrl: String,
    val price: String
)

data class BookDetailUiModel(
    val isbn13: String,
    val title: String,
    val subTitle: String,
    val coverImageUrl: String,
    val price: String,
    val isbn10: String,
    val publisher: String,
    val pages: Int,
    val authors: String,
    val language: String,
    val year: String,
    val rating: String,
    val description: String
)

fun Book.toUiModel(): BookUiModel =
    BookUiModel(
        isbn13 = isbn13,
        title = title,
        subTitle = subTitle,
        coverImageUrl = imageUrl,
        price = price
    )

fun Book.toDetailUiModel(): BookDetailUiModel =
    BookDetailUiModel(
        isbn13 = isbn13,
        title = title,
        subTitle = subTitle,
        coverImageUrl = imageUrl,
        price = price,
        isbn10 = isbn10,
        publisher = publisher,
        pages = pages,
        authors = authors,
        language = language,
        year = year,
        rating = rating,
        description = description
    )