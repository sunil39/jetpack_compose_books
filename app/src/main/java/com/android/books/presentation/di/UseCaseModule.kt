package com.android.books.presentation.di

import com.android.books.domain.repository.BookRepository
import com.android.books.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 08/08/21.
 * Dependency Injection for UserCases
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

   @Singleton
   @Provides
   fun provideSaveBookUseCase(
       bookRepository: BookRepository
   ):SaveBookUseCase{
      return SaveBookUseCase(bookRepository)
   }

   @Singleton
   @Provides
   fun provideGetSavedBooksUseCase(bookRepository: BookRepository):GetSavedBooksUseCase{
      return GetSavedBooksUseCase(bookRepository)
   }

}


















