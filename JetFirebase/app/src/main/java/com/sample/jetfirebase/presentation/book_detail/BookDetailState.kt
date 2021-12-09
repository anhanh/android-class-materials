package com.sample.jetfirebase.presentation.book_detail

import com.sample.jetfirebase.model.Book

data class BookDetailState(
    val isLoading: Boolean = false,
    val book: Book? = null,
    val error: String = ""
)
