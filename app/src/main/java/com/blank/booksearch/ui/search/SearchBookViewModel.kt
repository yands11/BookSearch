package com.blank.booksearch.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.blank.booksearch.domain.SearchBookUseCase
import com.blank.booksearch.ui.common.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel @Inject constructor(
    private val searchBookUseCase: SearchBookUseCase
) : ViewModel() {

    val input = MutableLiveData<String>()
    val uiModels = input.asFlow()
        .debounce(500L)
        .flatMapLatest { input ->
            Pager(PagingConfig(pageSize = 10)) {
                SearchBookPagingSource(input, searchBookUseCase)
            }.flow
        }.map { pagingData ->
            pagingData.map { it.toUiModel() }
        }.cachedIn(viewModelScope)

}