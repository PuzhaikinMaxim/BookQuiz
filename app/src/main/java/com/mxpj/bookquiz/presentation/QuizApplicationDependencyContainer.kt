package com.mxpj.bookquiz.presentation

import com.mxpj.bookquiz.data.*
import com.mxpj.bookquiz.domain.BookQuizResultRepository

class QuizApplicationDependencyContainer(private val application: QuizApplication) {

    private val bookDao = BookQuizDatabase.getDatabase(application).bookDao()

    private val mapper = BookMapper()

    val bookQuizResultRepository = BookQuizResultRepositoryImpl()

    val bookRepository = BookRepositoryImpl(bookDao, mapper)
}