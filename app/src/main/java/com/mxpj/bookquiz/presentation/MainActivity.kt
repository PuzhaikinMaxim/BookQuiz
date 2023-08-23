package com.mxpj.bookquiz.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.FragmentTitleBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        FragmentTitleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}