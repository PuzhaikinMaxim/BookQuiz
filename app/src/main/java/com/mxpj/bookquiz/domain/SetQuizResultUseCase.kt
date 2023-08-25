package com.mxpj.bookquiz.domain

class SetQuizResultUseCase(
    private val bookQuizResultRepository: BookQuizResultRepository
) {

    operator fun invoke(answers: List<Answer>) {
        bookQuizResultRepository.setQuizResult(answers)
    }
}