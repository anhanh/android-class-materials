package com.sample.jetfirebase.presentation.book_list.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sample.jetfirebase.model.Book
import com.sample.jetfirebase.ui.theme.Red100
import com.sample.jetfirebase.ui.theme.Yellow600

@ExperimentalMaterialApi
@Composable
fun BookListItem(
  book: Book,
  onItemClick: (String) -> Unit
) {
  Card(
    elevation = 0.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .clickable { onItemClick(book.id) },
      verticalAlignment = Alignment.CenterVertically
    ) {
      Image(
        painter = rememberImagePainter(book.image),
        contentDescription = "",
        modifier = Modifier
          .width(100.dp)
          .height(160.dp)
          .padding(8.dp)
      )

      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          modifier = Modifier.fillMaxWidth(),
          text = book.title,
          style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
          )
        )

        Text(
          modifier = Modifier.fillMaxWidth(),
          text = book.author,
          style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            color = Color.DarkGray
          )
        )
      }
    }
  }
}