package com.mxpj.bookquiz.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mxpj.bookquiz.domain.GetBookListUseCase
import com.mxpj.bookquiz.presentation.viewmodel.QuizViewModel

class QuizViewModelFactory(
    private val getBookListUseCase: GetBookListUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuizViewModel(getBookListUseCase) as T
    }
}