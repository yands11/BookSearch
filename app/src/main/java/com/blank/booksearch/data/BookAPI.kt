package com.blank.booksearch.data

import retrofit2.http.GET
import retrofit2.http.Path

interface BookAPI {

    @GET("new")
    suspend fun getNewBooks(): BooksResponse

    @GET("books/{isbn}")
    suspend fun getBookDetail(
        @Path("isbn") isbn13: String
    ): BookDetailResponse

    @GET("search/{query}/{page}")
    suspend fun searchBooks(
        @Path("query") query: String,
        @Path("page") page: Int
    ): BooksResponse
}