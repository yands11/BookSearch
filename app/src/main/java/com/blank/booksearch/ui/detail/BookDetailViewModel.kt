package com.blank.booksearch.ui.detail

import androidx.lifecycle.*
import com.blank.booksearch.domain.GetBookDetailUseCase
import com.blank.booksearch.domain.Result
import com.blank.booksearch.ui.common.BookDetailUiModel
import com.blank.booksearch.ui.common.toDetailUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
    private val getBookDetailUseCase: GetBookDetailUseCase
) : ViewModel() {

    private val _bookDetailUiModel = MutableLiveData<BookDetailUiModel>()
    val coverImageUrl: LiveData<String> = _bookDetailUiModel.map { it.coverImageUrl }
    val title: LiveData<String> = _bookDetailUiModel.map { it.title }
    val subTitle: LiveData<String> = _bookDetailUiModel.map { it.subTitle }
    val authors: LiveData<String> = _bookDetailUiModel.map { it.authors }
    val publisher: LiveData<String> = _bookDetailUiModel.map { it.publisher }
    val language: LiveData<String> = _bookDetailUiModel.map { it.language }
    val isbn10: LiveData<String> = _bookDetailUiModel.map { it.isbn10 }
    val isbn13: LiveData<String> = _bookDetailUiModel.map { it.isbn13 }
    val page: LiveData<String> = _bookDetailUiModel.map { "${it.pages} pages" }
    val year: LiveData<String> = _bookDetailUiModel.map { it.year }
    val rating: LiveData<String> = _bookDetailUiModel.map { it.rating }
    val price: LiveData<String> = _bookDetailUiModel.map { it.price }
    val description: LiveData<String> = _bookDetailUiModel.map { it.description }

    fun setupIsbn(isbn: String) {
        viewModelScope.launch {
            val res = withContext(Dispatchers.IO) { getBookDetailUseCase(isbn) }
            when (res) {
                is Result.Success -> {
                    _bookDetailUiModel.value = res.data.toDetailUiModel()
                }
                is Result.Error -> Timber.e(res.exception)
            }
        }
    }

}