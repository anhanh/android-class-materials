package com.sample.jetfirebase.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.sample.jetfirebase.data.Book

class BooksViewModel : ViewModel() {
  private val _books = mutableStateOf<List<Book>>(emptyList())
  val books: State<List<Book>>
    get() = _books

  private val query = Firebase.firestore.collection("books")

  init {
    query.addSnapshotListener { value, _ ->
      if (value != null) {
        _books.value = value.toObjects()
      }
    }
  }
}