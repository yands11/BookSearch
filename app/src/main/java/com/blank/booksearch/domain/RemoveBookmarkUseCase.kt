package com.blank.booksearch.domain

import java.lang.Exception

class RemoveBookmarkUseCase(private val bookmarkRepository: BookmarkRepository) {

    operator fun invoke(isbn13: String): Result<Unit> =
        try {
            bookmarkRepository.removeBookmarkByIsbn(isbn13)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e)
        }
}