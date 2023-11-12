package com.example.androidapparchitecture.mvvm.model.repository

import com.example.androidapparchitecture.common.data.MovieDataStore

class MovieRepository {

    private val dataStore = MovieDataStore()

    fun getMovies() = dataStore.getMovies()
}