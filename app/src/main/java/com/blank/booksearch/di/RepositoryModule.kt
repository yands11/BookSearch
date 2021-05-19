package com.blank.booksearch.di

import com.blank.booksearch.data.BookAPI
import com.blank.booksearch.data.BookRepositoryImpl
import com.blank.booksearch.data.BookmarkRepositoryImpl
import com.blank.booksearch.domain.BookRepository
import com.blank.booksearch.domain.BookmarkRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(bookAPI: BookAPI): BookRepository =
        BookRepositoryImpl(bookAPI)

    @Provides
    @Singleton
    fun provideBookmarkRepository(): BookmarkRepository =
        BookmarkRepositoryImpl()
}