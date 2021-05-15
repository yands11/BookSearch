package com.blank.booksearch.entity

data class Book(
    val isbn13: String,
    val title: String,
    val subTitle: String,
    val price: String,
    val image: String,
    val url: String,
    val isbn10: String = "",
    val publisher: String = "",
    val pages: Int = 0,
    val authors: String = "",
    val language: String = "",
    val year: String = "",
    val rating: String = "",
    val description: String = ""
)
