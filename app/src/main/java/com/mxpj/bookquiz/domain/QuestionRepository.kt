package com.mxpj.bookquiz.domain

import androidx.lifecycle.LiveData

interface QuestionRepository {

    fun getQuestionLdUseCase(): LiveData<Question>
}