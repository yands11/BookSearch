package com.blank.booksearch.ui.detail

import androidx.lifecycle.*
import com.blank.booksearch.domain.*
import com.blank.booksearch.entity.Book
import com.blank.booksearch.ui.common.BookDetailUiModel
import com.blank.booksearch.ui.common.toDetailUiModel
import com.blank.booksearch.ui.common.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
    private val getBookDetailUseCase: GetBookDetailUseCase,
    private val findBookmarkByIsbnUseCase: FindBookmarkByIsbnUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val removeBookmarkUseCase: RemoveBookmarkUseCase
) : ViewModel() {

    private val _book = MutableLiveData<Book>()
    private val _bookDetailUiModel = _book.map { it.toDetailUiModel() }
    private val _isBookmarked = MutableLiveData<Boolean>()
    val isBookmarked: LiveData<Boolean> get() = _isBookmarked
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
                    _book.value = res.data
                    checkBookmark(res.data.isbn13)
                }
                is Result.Error -> Timber.e(res.exception)
            }
        }
    }

    private fun checkBookmark(isbn13: String) {
        val res = findBookmarkByIsbnUseCase(isbn13)
        when (res) {
            is Result.Success -> _isBookmarked.value = true
            is Result.Error -> {
                _isBookmarked.value = false
                Timber.e(res.exception)
            }
        }
    }

    private fun addBookmark(book: Book) {
        val res = addBookmarkUseCase(book)
        when (res) {
            is Result.Success -> _isBookmarked.value = true
            is Result.Error -> Timber.e(res.exception)
        }
    }

    private fun removeBookmark(isbn13: String) {
        val res = removeBookmarkUseCase(isbn13)
        when (res) {
            is Result.Success -> _isBookmarked.value = false
            is Result.Error -> Timber.e(res.exception)
        }
    }

    fun clickBookmark() {
        _isBookmarked.value?.let { isBookmarked ->
            if (isBookmarked) {
                _book.value?.let { removeBookmark(it.isbn13) }
            } else {
                _book.value?.let { addBookmark(it) }
            }
        }
    }

}