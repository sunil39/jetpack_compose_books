package com.android.books.presentation.di

import android.app.Application
import com.android.books.domain.usecase.*
import com.android.books.presentation.viewmodel.BooksViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 08/08/21.
 * Dependency Injection for ViewModelFactory
 */
@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideBooksViewModelFactory(
        application: Application,
        saveBookUseCase: SaveBookUseCase,
        getSavedBooksUseCase: GetSavedBooksUseCase
  ):BooksViewModelFactory{
      return BooksViewModelFactory(
          application,
          saveBookUseCase,
          getSavedBooksUseCase
      )
  }

}








