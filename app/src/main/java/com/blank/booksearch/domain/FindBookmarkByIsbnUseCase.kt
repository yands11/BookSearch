package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book
import java.lang.Exception

class FindBookmarkByIsbnUseCase(
    private val repository: BookmarkRepository
) {
    operator fun invoke(isbn13: String): Result<Book> =
        try {
            val res = repository.findBookmarkByIsbn(isbn13)
            Result.Success(res)
        } catch (e: Exception) {
            Result.Error(e)
        }
}