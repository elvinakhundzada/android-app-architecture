package com.example.androidapparchitecture.mvi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapparchitecture.common.ui.adapter.MoviesListAdapter
import com.example.androidapparchitecture.databinding.ActivityMviBinding
import com.example.androidapparchitecture.mvi.viewmodel.MviViewModel
import com.example.androidapparchitecture.mvvm.viewmodel.MovieViewModel

class MviActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMviBinding
    private lateinit var adapter: MoviesListAdapter

    private lateinit var viewModel: MviViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupActionBar()
        setupAdapter()
        setupViewModel()
        fetchMovies()
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.tbMovies)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    private fun setupBinding() {
        binding = ActivityMviBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun setupAdapter() {
        adapter = MoviesListAdapter(this)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.rvMovies.layoutManager = layoutManager
        binding.rvMovies.adapter = adapter
    }
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this) [MviViewModel::class.java]
    }
    private fun fetchMovies(){

    }
}