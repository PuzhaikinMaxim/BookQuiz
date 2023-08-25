package com.mxpj.bookquiz.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.ActivityMainBinding
import com.mxpj.bookquiz.databinding.FragmentTitleBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}