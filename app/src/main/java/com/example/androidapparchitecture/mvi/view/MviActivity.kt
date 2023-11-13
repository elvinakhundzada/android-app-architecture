package com.example.androidapparchitecture.mvi.view

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapparchitecture.common.ui.adapter.MoviesListAdapter
import com.example.androidapparchitecture.databinding.ActivityMviBinding
import com.example.androidapparchitecture.mvi.base.BaseMviActivity
import com.example.androidapparchitecture.mvi.base.UiState
import com.example.androidapparchitecture.mvi.contract.MviContract
import com.example.androidapparchitecture.mvi.viewmodel.MviViewModel
import com.example.androidapparchitecture.mvvm.viewmodel.MovieViewModel

class MviActivity : BaseMviActivity<
        MviContract.MviState,
        MviContract.MviIntent,
        MviContract.MviEffect,
        MviViewModel>() {

    private lateinit var binding: ActivityMviBinding
    private lateinit var adapter: MoviesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupActionBar()
        setupAdapter()
        fetchMovies()
    }

    override fun setupViewModel() = ViewModelProvider(this) [MviViewModel::class.java]
    override fun invalidateEffect(effect: MviContract.MviEffect) {
        when(effect) {
            MviContract.MviEffect.MoviesLoaded -> {
                Toast.makeText(this, "Movies Loaded", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun invalidateState(state: MviContract.MviState) {
        when(state) {
            is MviContract.MviState.Loading -> {
                showLoading()
            }
            is MviContract.MviState.Error -> {
                showError(state.message)
            }
            is MviContract.MviState.Idle -> {

            }
            is MviContract.MviState.Success -> {
                adapter.setMovies(state.movieList)
            }
        }
    }

    private fun showLoading() {
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
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

    private fun fetchMovies() {
        viewModel.handleIntent(MviContract.MviIntent.LoadMovies)
    }
}