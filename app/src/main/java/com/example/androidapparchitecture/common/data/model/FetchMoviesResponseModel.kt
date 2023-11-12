package com.example.androidapparchitecture.common.data.model

import com.google.gson.annotations.SerializedName

data class FetchMoviesResponseModel(
    @SerializedName("Search")
    val movies: List<Movie>
)
