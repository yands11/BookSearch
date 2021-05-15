package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book

class GetNewBooksUseCase(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(): Result<List<Book>> =
        try {
            val res = bookRepository.getNewBooks()
            Result.Success(res)
        } catch (e: Exception) {
            Result.Error(e)
        }
}