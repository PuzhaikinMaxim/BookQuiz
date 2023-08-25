package com.mxpj.bookquiz.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mxpj.bookquiz.domain.GetQuizResultUseCase
import com.mxpj.bookquiz.presentation.viewmodel.QuizResultsViewModel

class QuizResultsViewModelFactory(
    private val getQuizResultUseCase: GetQuizResultUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuizResultsViewModel(getQuizResultUseCase) as T
    }
}