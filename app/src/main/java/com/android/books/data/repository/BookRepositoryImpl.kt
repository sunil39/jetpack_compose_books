package com.android.books.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.android.books.data.model.Book
import com.android.books.data.repository.dataSource.BookLocalDataSource
import com.android.books.domain.repository.BookRepository
/**
 * Created by Sunilkumar V on 08/08/21.
 */
class BookRepositoryImpl(private val bookLocalDataSource: BookLocalDataSource):BookRepository {

    override suspend fun saveBook(book: Book) {
        bookLocalDataSource.saveBookToDB(book)
    }

    override fun getBooks(): LiveData<List<Book>> {
        return bookLocalDataSource.getSavedBooks()
    }
}