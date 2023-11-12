package com.example.androidapparchitecture.common.data

import com.example.androidapparchitecture.BuildConfig
import com.example.androidapparchitecture.common.data.remote.MovieApi
import com.example.androidapparchitecture.common.ui.model.MovieUiModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDataStore {

    private val interceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build();

    private var mRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    
    private var mMoviesApi: MovieApi = mRetrofit.create(MovieApi::class.java)

    suspend fun fetchMovies() = mMoviesApi.fetchMovies()
}