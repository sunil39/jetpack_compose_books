package com.android.books.data.repository.dataSourceImpl

import androidx.lifecycle.LiveData
import com.android.books.data.db.BooksDAO
import com.android.books.data.model.Book
import com.android.books.data.repository.dataSource.BookLocalDataSource
/**
 * Created by Sunilkumar V on 08/08/21.
 */
class BookLocalDataSourceImpl(
    private val booksDAO: BooksDAO
) : BookLocalDataSource {
    override suspend fun saveBookToDB(book: Book) {
        booksDAO.insert(book)
    }

    override fun getSavedBooks(): LiveData<List<Book>> {
        return booksDAO.getAllBooks()
    }

}