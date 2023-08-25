package com.mxpj.bookquiz.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mxpj.bookquiz.domain.AnswerQuestionUseCase
import com.mxpj.bookquiz.domain.GetQuestionLdUseCase
import com.mxpj.bookquiz.presentation.viewmodel.QuizViewModel

class QuizViewModelFactory(
    private val getQuestionLdUseCase: GetQuestionLdUseCase,
    private val answerQuestionUseCase: AnswerQuestionUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuizViewModel(getQuestionLdUseCase, answerQuestionUseCase) as T
    }
}