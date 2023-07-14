package com.example.androidapparchitecture.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidapparchitecture.R
import com.example.androidapparchitecture.mvvm.viewmodel.MovieViewModel

class MvvmActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)

        viewModel = ViewModelProvider(this) [MovieViewModel::class.java]
    }
}