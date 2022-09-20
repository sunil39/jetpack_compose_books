package com.android.books.domain.repository

import androidx.lifecycle.LiveData
import com.android.books.data.model.Book
/**
 * Created by Sunilkumar V on 08/08/21.
 */
interface BookRepository{

      suspend fun saveBook(book: Book)
      fun getBooks(): LiveData<List<Book>>

}