package com.example.androidapparchitecture.mvp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.androidapparchitecture.databinding.ActivityMvpBinding
import com.example.androidapparchitecture.mvp.contract.MvpMovieContract
import com.example.androidapparchitecture.mvp.model.MvpMovie
import com.example.androidapparchitecture.mvp.presenter.MvpMoviePresenter

class MvpActivity : AppCompatActivity(), MvpMovieContract.MvpView {

    private lateinit var binding: ActivityMvpBinding
    private lateinit var adapter: MvpMoviesListAdapter

    private lateinit var presenter: MvpMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupActionBar()
        setupAdapter()
        setupPresenter()

        fetchMovies()
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.tbMovies)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupBinding() {
        binding = ActivityMvpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupAdapter() {
        adapter = MvpMoviesListAdapter(this)

        val layoutManager = LinearLayoutManager(this, VERTICAL, false)

        binding.rvMovies.layoutManager = layoutManager
        binding.rvMovies.adapter = adapter
    }

    private fun setupPresenter() {
        presenter = MvpMoviePresenter(this)
    }

    private fun fetchMovies() {
        presenter.fetchMovies()
    }

    override fun showMovies(movieList: List<MvpMovie>) {
        binding.tvEmpty.visibility = View.GONE
        binding.rvMovies.visibility = View.VISIBLE
        adapter.setMovies(movieList)
    }

    override fun noMoviesFound() {
        binding.tvEmpty.visibility = View.VISIBLE
        binding.rvMovies.visibility = View.GONE
        adapter.setMovies(emptyList())
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}