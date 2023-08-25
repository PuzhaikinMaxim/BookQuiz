package com.mxpj.bookquiz.domain

import androidx.lifecycle.LiveData

class GetQuestionLdUseCase(
    private val questionRepository: QuestionRepository
) {

    operator fun invoke(): LiveData<Question> {
        return questionRepository.getQuestionLdUseCase()
    }
}