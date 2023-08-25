package com.mxpj.bookquiz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mxpj.bookquiz.databinding.FragmentQuizResultsBinding
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
    ): View? {
        _binding = FragmentQuizResultsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(
            requireActivity(),
            QuizResultsViewModelFactory()
        )[QuizResultsViewModel::class.java]
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}