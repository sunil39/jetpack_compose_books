package com.android.books.presentation.di

import android.app.Application
import androidx.room.Room
import com.android.books.data.db.BookDatabase
import com.android.books.data.db.BooksDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * Created by Sunilkumar V on 08/08/21.
 * Dependency Injection for Database
 */
@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideBooksDatabase(app: Application): BookDatabase {
        return Room.databaseBuilder(app, BookDatabase::class.java, "books_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBooksDao(booksDatabase: BookDatabase): BooksDAO {
        return booksDatabase.getBookDAO()
    }


}