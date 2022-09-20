package com.android.books.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.books.data.model.Book
/**
 * Created by Sunilkumar V on 08/08/21.
 */
@Dao
interface BooksDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Query("SELECT * FROM books ORDER BY id DESC")
    fun getAllBooks(): LiveData<List<Book>>

}