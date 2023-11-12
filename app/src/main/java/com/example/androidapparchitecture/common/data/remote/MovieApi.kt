package com.example.androidapparchitecture.common.data.remote

import com.example.androidapparchitecture.common.ui.model.Movie
import retrofit2.http.GET

interface MovieApi {
    @GET
    fun fetchMovies() : List<Movie>
}