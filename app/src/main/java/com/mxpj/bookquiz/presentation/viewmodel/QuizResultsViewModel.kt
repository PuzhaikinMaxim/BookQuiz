package com.mxpj.bookquiz.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mxpj.bookquiz.domain.GetQuizResultUseCase
import com.mxpj.bookquiz.domain.QuizResult

class QuizResultsViewModel(
    getQuizResultUseCase: GetQuizResultUseCase
): ViewModel() {

    private val _quizResult = MutableLiveData<QuizResult>()
    val quizResult: LiveData<QuizResult>
        get() = _quizResult

    init {
        _quizResult.value = getQuizResultUseCase()
    }
}