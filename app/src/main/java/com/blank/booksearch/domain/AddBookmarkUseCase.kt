package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book
import java.lang.Exception

class AddBookmarkUseCase(private val bookmarkRepository: BookmarkRepository) {

    operator fun invoke(book: Book): Result<Unit> =
        try {
            bookmarkRepository.addBookmark(book)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e)
        }
}
