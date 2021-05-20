package com.blank.booksearch.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blank.booksearch.domain.GetBookmarksUseCase
import com.blank.booksearch.domain.Result
import com.blank.booksearch.ui.common.BookUiModel
import com.blank.booksearch.ui.common.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val getBookmarksUseCase: GetBookmarksUseCase
) : ViewModel() {

    private val _uiModels = MutableLiveData<List<BookUiModel>>()
    val uiModels: LiveData<List<BookUiModel>> get() = _uiModels

    init {
        refreshUiModel()
    }

    fun refreshUiModel() {
        viewModelScope.launch {
            val res = getBookmarksUseCase()
            when (res) {
                is Result.Success -> {
                    _uiModels.value = res.data.map { it.toUiModel() }
                }
                is Result.Error -> Timber.e(res.exception)
            }
        }
    }
}
