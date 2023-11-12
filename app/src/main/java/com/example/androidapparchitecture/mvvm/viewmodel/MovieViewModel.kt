package com.example.androidapparchitecture.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapparchitecture.mvvm.model.repository.MovieRepository
import com.example.androidapparchitecture.common.ui.model.MovieUiModel
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

    private val movieRepository: MovieRepository = MovieRepository()

    private val movies: MutableLiveData<List<MovieUiModel>> = MutableLiveData()

    fun moviesLiveData() = movies
    fun fetchMovies() {

        viewModelScope.launch {
            val response = movieRepository.getMovies()

            if(response.movies.isNotEmpty()) {

                movies.postValue(response.movies.map {
                    MovieUiModel(
                        title = it.title,
                        poster = it.poster,
                        year = it.year
                    )
                })
            } else {
                // Will be implemented with upcoming updates.
            }
        }
    }
}