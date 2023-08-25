package com.mxpj.bookquiz.domain

data class Question(
    val books: ArrayList<Book>,
    val rightBook: Book
) {
}