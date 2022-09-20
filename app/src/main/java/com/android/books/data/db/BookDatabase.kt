package com.android.books.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.books.data.model.Book
/**
 * Created by Sunilkumar V on 08/08/21.
 */
@Database(
    entities = [Book::class],
    version = 2,
    exportSchema = false
)
abstract  class BookDatabase : RoomDatabase(){
    abstract fun getBookDAO():BooksDAO
}

