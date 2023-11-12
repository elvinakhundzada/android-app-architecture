package com.example.androidapparchitecture.common.data.remote

import com.example.androidapparchitecture.BuildConfig
import com.example.androidapparchitecture.common.data.model.FetchMoviesResponseModel
import com.example.androidapparchitecture.common.utils.RequestDefaults.SEARCH_DOCUMENTARY
import com.example.androidapparchitecture.common.utils.RequestDefaults.TYPE_MOVIE
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/")
    suspend fun fetchMovies(

        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY,

        @Query("s")
        search: String = SEARCH_DOCUMENTARY,

        @Query("type")
        type: String = TYPE_MOVIE,

    ) : FetchMoviesResponseModel
}