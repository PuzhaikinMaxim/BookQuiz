package com.mxpj.bookquiz.domain

import com.mxpj.bookquiz.data.BookDbModel

interface BookRepository {

    suspend fun getAllBooks(): List<Book>
}