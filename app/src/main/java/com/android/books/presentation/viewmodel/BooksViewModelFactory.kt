package com.android.books.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.books.domain.usecase.*
/**
 * Created by Sunilkumar V on 08/08/21.
 * ViewModelFactory class for BookViewModel
 */
class BooksViewModelFactory(
    private val app:Application,
    private val saveBookUseCase: SaveBookUseCase,
    private val getSavedBooksUseCase: GetSavedBooksUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BooksViewModel(
            app,
            saveBookUseCase,
            getSavedBooksUseCase,
        ) as T
    }
}









