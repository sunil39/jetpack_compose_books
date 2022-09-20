package com.android.books.domain.usecase

import com.android.books.data.model.Book
import com.android.books.domain.repository.BookRepository
/**
 * Created by Sunilkumar V on 08/08/21.
 * Created for Inserting book into database
 */
class SaveBookUseCase(private val bookRepository: BookRepository) {
  suspend fun execute(book: Book)=bookRepository.saveBook(book)
}