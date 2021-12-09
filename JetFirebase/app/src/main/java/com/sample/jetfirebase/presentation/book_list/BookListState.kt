package com.sample.jetfirebase.presentation.book_list

import com.sample.jetfirebase.model.Book

data class BookListState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val error: String = ""
)
