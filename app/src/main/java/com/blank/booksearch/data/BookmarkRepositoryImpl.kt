package com.blank.booksearch.data

import android.content.res.Resources
import com.blank.booksearch.domain.BookmarkRepository
import com.blank.booksearch.entity.Book
import timber.log.Timber

class BookmarkRepositoryImpl : BookmarkRepository {

    private val bookmarks by lazy { mutableListOf<Book>() }

    override fun addBookmark(book: Book) {
        val index = bookmarks.indexOfFirst { it.isbn13 == book.isbn13 }
        if (index >= 0) {
            bookmarks[index] = book
        } else {
            bookmarks.add(book)
        }
    }

    override fun removeBookmarkByIsbn(isbn13: String) {
        bookmarks.indexOfFirst { it.isbn13 == isbn13 }
            .takeIf { index -> index >= 0 }
            ?.let { index -> bookmarks.removeAt(index) }
    }

    override fun getBookmarkBooks(): List<Book> {
        return bookmarks
    }

    override fun clearBookmark() {
        bookmarks.clear()
    }

    override fun findBookmarkByIsbn(isbn13: String): Book {
        return bookmarks.find { it.isbn13 == isbn13 } ?: throw NoSuchElementException()
    }
}