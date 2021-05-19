package com.blank.booksearch.di

import com.blank.booksearch.domain.*
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

    @Provides
    @ViewModelScoped
    fun provideGetBookmarksUseCase(repository: BookmarkRepository): GetBookmarksUseCase =
        GetBookmarksUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideAddBookmarkUseCase(repository: BookmarkRepository): AddBookmarkUseCase =
        AddBookmarkUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideRemoveBookmarkUseCase(repository: BookmarkRepository): RemoveBookmarkUseCase =
        RemoveBookmarkUseCase(repository)

    @Provides
    @ViewModelScoped
    fun provideFindBookmarkByIsbnUseCase(repository: BookmarkRepository): FindBookmarkByIsbnUseCase =
        FindBookmarkByIsbnUseCase(repository)
}