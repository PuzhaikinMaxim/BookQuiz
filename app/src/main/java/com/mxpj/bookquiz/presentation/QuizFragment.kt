package com.mxpj.bookquiz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.FragmentQuizBinding
import com.mxpj.bookquiz.domain.GetBookListUseCase
import com.mxpj.bookquiz.domain.SetQuizResultUseCase
import com.mxpj.bookquiz.presentation.viewmodel.QuizViewModel
import com.mxpj.bookquiz.presentation.viewmodel.factories.QuizViewModelFactory

class QuizFragment() : ViewBindingFragment<FragmentQuizBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentQuizBinding
        get() = FragmentQuizBinding::inflate

    private lateinit var viewModel: QuizViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        setupQuestionObserver()
        setupCloseScreenObserver()
    }

    private fun initializeViewModel() {
        val application = requireActivity().application as QuizApplication
        viewModel = ViewModelProvider(
            this,
            QuizViewModelFactory(
                GetBookListUseCase(application.dependencyContainer.bookRepository),
                SetQuizResultUseCase(application.dependencyContainer.bookQuizResultRepository)
            )
        )[QuizViewModel::class.java]
    }

    private fun setupQuestionObserver() {
        val bookImageViews = arrayListOf(binding.ivBook1, binding.ivBook2, binding.ivBook3)
        viewModel.question.observe(requireActivity()){
            val books = it.books
            binding.tvBookText.text = it.rightBook.text
            for((index, book) in books.withIndex()){
                bookImageViews[index].setImageResource(book.imageResource)
                bookImageViews[index].setOnClickListener {
                    viewModel.answerQuestion(book)
                }
            }
        }
    }

    private fun setupCloseScreenObserver() {
        viewModel.isGameOver.observe(requireActivity()){
            findNavController().navigate(R.id.action_quizFragment_to_quizResultsFragment)
        }
    }

    override fun onDetach() {
        super.onDetach()
        if(this::viewModel.isInitialized){
            viewModel.question.removeObservers(requireActivity())
        }
    }
}