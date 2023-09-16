package com.mxpj.bookquiz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.FragmentTitleBinding

class TitleFragment() : ViewBindingFragment<FragmentTitleBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTitleBinding
        get() = FragmentTitleBinding::inflate

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