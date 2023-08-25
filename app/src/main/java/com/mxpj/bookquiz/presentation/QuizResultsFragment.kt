package com.mxpj.bookquiz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.FragmentQuizResultsBinding
import com.mxpj.bookquiz.domain.GetQuizResultUseCase
import com.mxpj.bookquiz.presentation.viewmodel.QuizResultsViewModel
import com.mxpj.bookquiz.presentation.viewmodel.factories.QuizResultsViewModelFactory

class QuizResultsFragment: Fragment() {

    private var _binding: FragmentQuizResultsBinding? = null
    private val binding: FragmentQuizResultsBinding
        get() = _binding ?: throw RuntimeException("FragmentQuizResultsBinding is null")

    private lateinit var viewModel: QuizResultsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizResultsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        setupAnswerListAdapter()
        setOnRestartButtonClickListener()
    }

    private fun initializeViewModel() {
        val application = requireActivity().application as QuizApplication
        viewModel = ViewModelProvider(
            this,
            QuizResultsViewModelFactory(
                GetQuizResultUseCase(application.dependencyContainer.bookQuizResultRepository)
            )
        )[QuizResultsViewModel::class.java]
    }

    private fun setupAnswerListAdapter() {
        val adapter = AnswerListAdapter(requireActivity())
        viewModel.quizResult.observe(requireActivity()){
            adapter.answerList = it.answers
        }
        binding.rvAnswerList.adapter = adapter
    }

    private fun setOnRestartButtonClickListener() {
        binding.btnRestart.setOnClickListener {
            findNavController().navigate(R.id.action_quizResultsFragment_to_quizFragment)
        }
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}