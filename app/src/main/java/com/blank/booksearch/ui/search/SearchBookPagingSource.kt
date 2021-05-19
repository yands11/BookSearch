package com.blank.booksearch.ui.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.blank.booksearch.domain.Result
import com.blank.booksearch.domain.SearchBookUseCase
import com.blank.booksearch.entity.Book

class SearchBookPagingSource(
    private val input: String,
    private val searchBookUseCase: SearchBookUseCase
) : PagingSource<Int, Book>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        val page = params.key ?: 1
        return when (val res = searchBookUseCase(input, page)) {
            is Result.Success ->
                LoadResult.Page(
                    data = res.data,
                    prevKey = null,
                    nextKey = res.data.takeIf { it.isNotEmpty() }?.let { page.plus(1) }
                )
            is Result.Error -> LoadResult.Error(res.exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Book>): Int? {
        return null
    }
}