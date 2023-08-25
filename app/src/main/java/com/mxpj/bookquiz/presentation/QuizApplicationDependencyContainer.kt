package com.mxpj.bookquiz.presentation

import com.mxpj.bookquiz.data.BookDbModel
import com.mxpj.bookquiz.data.BookMapper
import com.mxpj.bookquiz.data.BookQuizDatabase
import com.mxpj.bookquiz.data.BookRepositoryImpl

class QuizApplicationDependencyContainer(private val application: QuizApplication) {

    private val bookDao = BookQuizDatabase.getDatabase(application).bookDao()

    private val mapper = BookMapper()

    val bookRepository = BookRepositoryImpl(bookDao, mapper)
}