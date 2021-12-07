package com.sample.jetfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sample.jetfirebase.data.Book
import com.sample.jetfirebase.ui.theme.JetFirebaseTheme
import com.sample.jetfirebase.viewmodel.BooksViewModel

class MainActivity : ComponentActivity() {

  private val viewModel by viewModels<BooksViewModel>()

  @ExperimentalAnimationApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetFirebaseTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(viewModel.books.value) {
              Card(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
              ) {
                BookDetails(it)
              }
            }
          }
        }
      }
    }
  }
}

@ExperimentalAnimationApi
@Composable
fun BookDetails(book: Book) {
  var showBookDescription by remember { mutableStateOf(false) }
  val bookCoverImageSize by animateDpAsState(
    targetValue =
    if (showBookDescription) 50.dp else 80.dp
  )

  Column(modifier = Modifier.clickable {
    showBookDescription = showBookDescription.not()
  }) {
    Row(modifier = Modifier.padding(12.dp)) {

      Image(
        painter = rememberImagePainter(
          data = book.image,
          builder = {
            crossfade(true)
          }
        ),
        contentDescription = "Book cover page",
        modifier = Modifier.size(bookCoverImageSize)
      )

      Column {
        Text(
          text = book.name, style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
          )
        )

        Text(
          text = book.author, style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 12.sp
          )
        )
      }
    }

    AnimatedVisibility(visible = showBookDescription) {
      Text(
        text = book.description, style = TextStyle(
          fontWeight = FontWeight.SemiBold,
          fontStyle = FontStyle.Italic
        ),
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
      )
    }
  }

}

