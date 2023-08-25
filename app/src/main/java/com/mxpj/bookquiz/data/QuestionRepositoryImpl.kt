package com.mxpj.bookquiz.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mxpj.bookquiz.domain.Book
import com.mxpj.bookquiz.domain.BookRepository
import com.mxpj.bookquiz.domain.Question
import com.mxpj.bookquiz.domain.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionRepositoryImpl(
    private val bookRepository: BookRepository
): QuestionRepository {

    private var books = ArrayList<Book>()

    init {
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            books.addAll(bookRepository.getAllBooks())
        }
    }

    private fun prepareNextQuestion() {

    }

    private val question = MutableLiveData<Question>()

    override fun getQuestionLdUseCase(): LiveData<Question> {
        return question
    }

}