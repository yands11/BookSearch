package com.blank.booksearch.data

import com.blank.booksearch.entity.Book
import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("error") val error: String,
    @SerializedName("page") val page: Int,
    @SerializedName("books") val books: List<BookResponse>
)

data class BookResponse(
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subTitle: String,
    @SerializedName("isbn13") val isbn13: String,
    @SerializedName("price") val price: String,
    @SerializedName("image") val image: String,
    @SerializedName("url") val url: String
)

fun BookResponse.toEntity(): Book =
    Book(
        isbn13 = isbn13,
        title = title,
        subTitle = subTitle,
        price = price,
        image = image,
        url = url
    )

data class BookDetailResponse(
    @SerializedName("error") val error: String,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subTitle: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("pages") val pages: Int,
    @SerializedName("authors") val authors: String,
    @SerializedName("isbn13") val isbn13: String,
    @SerializedName("isbn10") val isbn10: String,
    @SerializedName("price") val price: String,
    @SerializedName("image") val image: String,
    @SerializedName("url") val url: String,
    @SerializedName("language") val language: String,
    @SerializedName("year") val year: String,
    @SerializedName("rating") val rating: String,
    @SerializedName("desc") val description: String,
)


fun BookDetailResponse.toEntity(): Book =
    Book(
        isbn13 = isbn13,
        title = title,
        subTitle = subTitle,
        price = price,
        image = image,
        url = url,
        isbn10 = isbn10,
        publisher = publisher,
        pages = pages,
        authors = authors,
        language = language,
        year = year,
        rating = rating,
        description = description
    )
