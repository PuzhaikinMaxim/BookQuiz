package com.mxpj.bookquiz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.mxpj.bookquiz.domain.AnswerQuestionUseCase
import com.mxpj.bookquiz.domain.GetQuestionLdUseCase

class QuizViewModel(
    private val getNewQuestionUseCase: GetQuestionLdUseCase,
    private val answerQuestionUseCase: AnswerQuestionUseCase
): ViewModel() {
}