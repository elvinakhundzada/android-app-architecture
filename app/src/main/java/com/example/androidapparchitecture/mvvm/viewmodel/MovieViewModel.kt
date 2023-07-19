package com.example.androidapparchitecture.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapparchitecture.mvvm.model.repository.MovieRepository
import com.example.androidapparchitecture.common.ui.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

    private val movieRepository: MovieRepository = MovieRepository()

    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    fun moviesLiveData() = movies
    fun fetchMovies() {

        viewModelScope.launch {
            val moviesList = movieRepository.getMovies()

            if(moviesList.isNotEmpty()) {
                movies.postValue(moviesList)
            } else {
                // Will be implemented with upcoming updates.
            }
        }
    }
}