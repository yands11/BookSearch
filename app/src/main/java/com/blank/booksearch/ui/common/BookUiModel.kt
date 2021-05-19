package com.blank.booksearch.ui.common

import com.blank.booksearch.entity.Book

data class BookUiModel(
    val isbn13: String,
    val title: String,
    val subTitle: String,
    val coverImageUrl: String,
    val price: String
)

fun Book.toUiModel(): BookUiModel =
    BookUiModel(
        isbn13 = isbn13,
        title = title,
        subTitle = subTitle,
        coverImageUrl = imageUrl,
        price = price
    )
