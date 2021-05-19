package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book
import java.lang.Exception

class GetBookmarksUseCase(private val bookmarkRepository: BookmarkRepository) {

    operator fun invoke(): Result<List<Book>> =
        try {
            Result.Success(bookmarkRepository.getBookmarkBooks())
        } catch (e: Exception) {
            Result.Error(e)
        }
}