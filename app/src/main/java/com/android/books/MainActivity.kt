package com.android.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.android.books.data.model.Book
import com.android.books.presentation.ui.compose.BookListItem
import com.android.books.presentation.viewmodel.BooksViewModel
import com.android.books.presentation.viewmodel.BooksViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
/**
 * Created by Sunilkumar V on 08/08/21.
 * In this project we are adding and listing books in Jetpack compose
 * Created for the purpose of Technical round
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: BooksViewModelFactory
    private lateinit var viewModel: BooksViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(BooksViewModel::class.java)
        loadBooks()
    }

    private fun loadBooks(){
        viewModel.getSavedBook().observe(this) {
            setContent {
                ScaffoldView(books = it)
            }
        }
    }

    @Composable
    fun ScaffoldView(books: List<Book>) {
        val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
        Scaffold(
            backgroundColor = Color.White,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    backgroundColor = Color.Black,
                    icon = { Icon(Icons.Filled.Add, "",tint = Color.White) },
                    text = { Text(text = "ADD",color = Color.White) },
                    onClick = { setShowDialog(true) },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp)
                )
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Books")
                    },
                    backgroundColor = Color.Black,
                    contentColor = Color.White,
                    elevation = 2.dp
                )
            },
            bottomBar = {

            }
        ) {
            Box {
                if(books.isEmpty()){
                    LoadNoBooks()
                }
                else {
                    LoadBooks(books)
                }
            }
        }
        DialogDemo(showDialog, setShowDialog)
    }

    @Composable
    fun DialogDemo(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                },
                title = {
                    Text(
                        text = "Add Book",
                        color = Color.LightGray,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                dismissButton = {
                    Button(
                        onClick = {
                            setShowDialog(false)
                        }, Modifier.padding(15.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black,contentColor = Color.White)
                    ) {
                        Text("Close")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.saveBook().observe(this){
                                if(it){
                                    setShowDialog(false)
                                }
                                else{
                                    Toast.makeText(this,"Please fill all fields",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                        }, Modifier.padding(15.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black,contentColor = Color.White)
                    ) {
                        Text("Save")
                    }
                },
                text = {
                    Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "Book Name",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body2,
                            overflow = TextOverflow.Ellipsis
                        )
                        TextField(
                            value = viewModel.bookName.value,
                            onValueChange = { viewModel.bookNameChanged(it) }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Book Author",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body2,
                            overflow = TextOverflow.Ellipsis
                        )
                        TextField(
                            value = viewModel.bookAuthor.value,
                            onValueChange = { viewModel.bookAuthorChanged(it) }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Book Description",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body2,
                            overflow = TextOverflow.Ellipsis
                        )
                        TextField(
                            value = viewModel.bookDescription.value,
                            onValueChange = { viewModel.bookDescriptionChanged(it) }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                },
            )
        }
    }
}

@Composable
fun LoadBooks(books: List<Book>){
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        items(books) { book ->
            BookListItem(book)
        }
    }
}

@Composable
fun LoadNoBooks(){
    Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.no_data),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(110.dp)
                .width(200.dp)
        )
    }

}





