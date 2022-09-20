package com.android.books.presentation.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.books.data.model.Book
/**
 * Created by Sunilkumar V on 08/08/21.
 * Jetpack compose card for listing books (book cardView)
 */
@Composable
fun BookListItem(book: Book) {
    Card(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth(),elevation = 10.dp,shape = RoundedCornerShape(corner = CornerSize(5.dp))) {
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(
                    text = book.name,
                    color= Color.Black,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = book.description,
                    color = Color.LightGray,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.body2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Column(Modifier.fillMaxWidth(),horizontalAlignment = Alignment.Start) {

                    Text(
                        text = book.author,
                        color = MaterialTheme.colors.secondaryVariant,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}