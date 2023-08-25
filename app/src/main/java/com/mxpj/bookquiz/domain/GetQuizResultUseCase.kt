package com.mxpj.bookquiz.domain

class GetQuizResultUseCase(
    private val bookQuizResultRepository: BookQuizResultRepository
) {

    operator fun invoke(): QuizResult {
        return bookQuizResultRepository.getQuizResult()
    }
}