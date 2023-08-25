package com.mxpj.bookquiz.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mxpj.bookquiz.presentation.viewmodel.QuizResultsViewModel

class QuizResultsViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuizResultsViewModel() as T
    }
}