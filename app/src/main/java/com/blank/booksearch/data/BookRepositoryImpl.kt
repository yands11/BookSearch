package com.blank.booksearch.data

import com.blank.booksearch.domain.BookRepository
import com.blank.booksearch.entity.Book

class BookRepositoryImpl(
    private val bookAPI: BookAPI
) : BookRepository {

    override suspend fun getNewBooks(): List<Book> =
        bookAPI.getNewBooks()
            .books.map { it.toEntity() }

    override suspend fun searchBooks(query: String, page: Int): List<Book> =
        bookAPI.searchBooks(query, page)
            .books.map { it.toEntity() }

    override suspend fun getBookDetail(isbn13: String): Book =
        bookAPI.getBookDetail(isbn13).toEntity()
}