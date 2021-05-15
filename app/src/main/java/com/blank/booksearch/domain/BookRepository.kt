package com.blank.booksearch.domain

import com.blank.booksearch.entity.Book

interface BookRepository {

    /**
     *  신간도서를 불러옵니다.
     */
    suspend fun getNewBooks(): List<Book>

    /**
     * 도서를 검색합니다.
     * @param   query   검색어 (by title, author, ISBN or keywords)
     * @param   page    페이지 (default = 1)
     */
    suspend fun searchBooks(
        query: String,
        page: Int
    ): List<Book>

    /**
     *  도서 상세정보를 불러옵니다.
     */
    suspend fun getBookDetail(isbn: String): Book
}