package com.example.redditapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.redditapp.components.ImagePost
import com.example.redditapp.components.TextPost
import com.example.redditapp.domain.model.PostModel
import com.example.redditapp.domain.model.PostType
import com.example.redditapp.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
  val posts: List<PostModel> by viewModel.allPosts.observeAsState(listOf())

  LazyColumn(
    modifier = Modifier.background(color = MaterialTheme.colors.secondary)
  ) {
    items(posts) {
      if (it.type == PostType.TEXT) {
        TextPost(it)
      } else {
        ImagePost(it)
      }
      Spacer(modifier = Modifier.height(6.dp))
    }
  }
}