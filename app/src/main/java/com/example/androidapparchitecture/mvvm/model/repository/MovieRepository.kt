package com.example.androidapparchitecture.mvvm.model.repository

import com.example.androidapparchitecture.mvp.model.MovieDataStore

class MovieRepository {

    private val dataStore = MovieDataStore()

    fun getMovies() = dataStore.getMovies()
}