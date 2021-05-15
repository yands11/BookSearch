package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book
import java.lang.Exception

class GetBookDetailUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(isbn: String): Result<Book> =
        try {
            val res = bookRepository.getBookDetail(isbn)
            Result.Success(res)
        } catch (e: Exception) {
            Result.Error(e)
        }
}