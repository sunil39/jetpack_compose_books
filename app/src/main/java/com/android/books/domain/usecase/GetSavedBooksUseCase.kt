package com.android.books.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import com.android.books.data.model.Book
import com.android.books.domain.repository.BookRepository
/**
 * Created by Sunilkumar V on 08/08/21.
 * Created for getting books from database
 */
class GetSavedBooksUseCase(private val bookRepository: BookRepository) {
    fun execute(): LiveData<List<Book>>{
        return bookRepository.getBooks()
    }
}