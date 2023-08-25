package com.mxpj.bookquiz.domain

interface BookQuizResultRepository {

    fun setQuizResult(answers: List<Answer>)

    fun getQuizResult(): QuizResult
}