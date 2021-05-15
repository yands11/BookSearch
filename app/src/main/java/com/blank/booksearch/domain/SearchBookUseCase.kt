package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book
import java.lang.Exception

class SearchBookUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(query: String, page: Int): Result<List<Book>> =
        try {
            val res = bookRepository.searchBooks(query, page)
            Result.Success(res)
        } catch (e: Exception) {
            Result.Error(e)
        }
}