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

    private var moviesList = arrayListOf(
        MovieUiModel("The Shawshank Redemption", "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg", "9.3")
    )

    suspend fun fetchMovies() = mMoviesApi.fetchMovies()

    fun getMovies(): List<MovieUiModel> {
        return moviesList
    }

    private fun getItemAt(index: Int): MovieUiModel {
        return moviesList[index]
    }

    private fun clearMovies() {
        moviesList.clear()
    }
}