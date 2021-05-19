package com.blank.booksearch.ui.newbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blank.booksearch.domain.GetNewBooksUseCase
import com.blank.booksearch.domain.Result
import com.blank.booksearch.ui.common.BookUiModel
import com.blank.booksearch.ui.common.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewBookViewModel @Inject constructor(
    private val newBooksUseCase: GetNewBooksUseCase
) : ViewModel() {

    private val _bookUiModel = MutableLiveData<List<BookUiModel>>()
    val bookUiModel: LiveData<List<BookUiModel>> get() = _bookUiModel

    init {
        viewModelScope.launch {
            when (val res = newBooksUseCase()) {
                is Result.Success -> {
                    _bookUiModel.value = res.data.map { it.toUiModel() }
                }
                is Result.Error -> {
                    Timber.e(res.exception)
                }
            }
        }
    }
}