package com.mxpj.bookquiz.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mxpj.bookquiz.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class QuizViewModel(
    private val getBookListUseCase: GetBookListUseCase
): ViewModel() {

    private val availableBooks = ArrayList<Book>()

    private var questionsLeft = AMOUNT_OF_QUESTIONS

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _isGameOver = MutableLiveData<Unit>()
    val isGameOver: LiveData<Unit>
        get() = _isGameOver

    private val answers = ArrayList<Answer>()

    init {
        viewModelScope.launch(Dispatchers.IO){
            val bookList = getBookListUseCase()
            availableBooks.addAll(bookList.shuffled())
            setNextQuestion()
        }
    }

    private fun setNextQuestion() {
        val availableBooksTemp = availableBooks.map { it }.toMutableList()
        val books = ArrayList<Book>()
        for(i in 0..2){
            val bookIndex = Random.nextInt(0, availableBooksTemp.size)
            books.add(availableBooksTemp[bookIndex])
            availableBooksTemp.removeAt(bookIndex)
        }
        _question.postValue(Question(books, books[Random.nextInt(0,3)]))
    }

    fun answerQuestion(book: Book) {
        answers.add(Answer(question.value!!, book))
        questionsLeft -= 1
        if(questionsLeft == 0){
            _isGameOver.value = Unit
        }
        else{
            setNextQuestion()
        }
    }

    companion object {
        private const val AMOUNT_OF_QUESTIONS = 10
    }
}