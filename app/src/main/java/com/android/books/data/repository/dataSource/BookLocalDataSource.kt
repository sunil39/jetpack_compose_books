package com.android.books.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.android.books.data.model.Book
/**
 * Created by Sunilkumar V on 08/08/21.
 */
interface BookLocalDataSource {
    suspend fun saveBookToDB(book: Book)
    fun getSavedBooks(): LiveData<List<Book>>
}