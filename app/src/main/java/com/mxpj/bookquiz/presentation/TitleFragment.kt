package com.mxpj.bookquiz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {

    private var _binding: FragmentTitleBinding? = null
    private val binding: FragmentTitleBinding
        get() = _binding ?: throw RuntimeException("FragmentTitleBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnPlayButtonClick()
    }

    private fun setOnPlayButtonClick() {
        binding.btnPlay.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_quizFragment)
        }
    }
}