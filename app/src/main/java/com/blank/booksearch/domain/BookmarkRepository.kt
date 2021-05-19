package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book

interface BookmarkRepository {

    fun addBookmark(book: Book)

    fun removeBookmarkByIsbn(isbn13: String)

    fun findBookmarkByIsbn(isbn13: String): Book

    fun getBookmarkBooks(): List<Book>

    fun clearBookmark()
}