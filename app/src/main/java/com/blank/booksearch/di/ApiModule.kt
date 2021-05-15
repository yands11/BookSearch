package com.blank.booksearch.di

import com.blank.booksearch.data.BookAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideBookAPI(retrofit: Retrofit): BookAPI =
        retrofit.create(BookAPI::class.java)
}