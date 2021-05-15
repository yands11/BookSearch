package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book
import java.lang.Exception

class GetBookDetailUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(isbn13: String): Result<Book> =
        try {
            val res = bookRepository.getBookDetail(isbn13)
            Result.Success(res)
        } catch (e: Exception) {
            Result.Error(e)
        }
}