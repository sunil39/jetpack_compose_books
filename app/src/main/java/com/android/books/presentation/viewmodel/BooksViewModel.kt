package com.android.books.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.android.books.data.model.Book
import com.android.books.domain.usecase.*
import kotlinx.coroutines.launch
/**
 * Created by Sunilkumar V on 08/08/21.
 * View model class for adding and listing books
 */
class BooksViewModel(
    app:Application,
    private val saveBookUseCase: SaveBookUseCase,
    private val getSavedBooksUseCase: GetSavedBooksUseCase
) : AndroidViewModel(app) {

    var bookName= mutableStateOf("")
    var bookAuthor= mutableStateOf("")
    var bookDescription= mutableStateOf("")
    private var validated = false


    fun saveBook() = liveData {
        validated = validateForm()
        emit(validated)
    }

    //local data
    private fun insertBook() = viewModelScope.launch {
        saveBookUseCase.execute(Book(0, bookName.value, bookAuthor.value, bookDescription.value))
        clearFields()
    }

    fun getSavedBook():LiveData<List<Book>>{
        return getSavedBooksUseCase.execute()
    }

    fun bookNameChanged(bookName:String){
        this.bookName.value = bookName
    }

    fun bookAuthorChanged(bookAuthor:String){
        this.bookAuthor.value = bookAuthor
    }

    fun bookDescriptionChanged(bookDescription:String){
        this.bookDescription.value = bookDescription
    }

    private fun validateForm():Boolean{
        return if(bookName.value.isNotEmpty() && bookAuthor.value.isNotEmpty() && bookDescription.value.isNotEmpty()){
            insertBook()
            true
        } else{
            false
        }
    }

    private fun clearFields() {
        bookName.value = ""
        bookAuthor.value = ""
        bookDescription.value = ""
    }

}














