package com.android.books.presentation.di

import com.android.books.data.db.BooksDAO
import com.android.books.data.repository.dataSource.BookLocalDataSource
import com.android.books.data.repository.dataSourceImpl.BookLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 08/08/21.
 * Dependency Injection for Database DAO class
 */
@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(booksDAO: BooksDAO):BookLocalDataSource{
      return BookLocalDataSourceImpl(booksDAO)
    }

}













