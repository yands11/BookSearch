package com.blank.booksearch.di

import com.blank.booksearch.domain.BookRepository
import com.blank.booksearch.domain.GetBookDetailUseCase
import com.blank.booksearch.domain.GetNewBooksUseCase
import com.blank.booksearch.domain.SearchBookUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetNewBooksUseCase(repository: BookRepository): GetNewBooksUseCase =
        GetNewBooksUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideSearchBookUseCase(repository: BookRepository): SearchBookUseCase =
        SearchBookUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideGetBookDetailUseCase(repository: BookRepository): GetBookDetailUseCase =
        GetBookDetailUseCase(repository)
}