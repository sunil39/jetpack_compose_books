package com.android.books.presentation.di

import com.android.books.data.repository.BookRepositoryImpl
import com.android.books.data.repository.dataSource.BookLocalDataSource
import com.android.books.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 08/08/21.
 * Dependency Injection for Repository
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBooksRepository(
        bookLocalDataSource: BookLocalDataSource
    ): BookRepository {
        return BookRepositoryImpl(
            bookLocalDataSource
        )
    }

}














