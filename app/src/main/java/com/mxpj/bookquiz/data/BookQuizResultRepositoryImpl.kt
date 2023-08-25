package com.mxpj.bookquiz.data

import com.mxpj.bookquiz.domain.Answer
import com.mxpj.bookquiz.domain.BookQuizResultRepository
import com.mxpj.bookquiz.domain.QuizResult

class BookQuizResultRepositoryImpl: BookQuizResultRepository {

    private var quizResult = QuizResult(listOf())

    override fun setQuizResult(answers: List<Answer>) {
        quizResult = QuizResult(answers)
    }

    override fun getQuizResult(): QuizResult {
        return quizResult
    }
}