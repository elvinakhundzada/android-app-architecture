package com.example.androidapparchitecture.mvp.contract

import com.example.androidapparchitecture.mvp.model.MvpMovie

class MvpMovieContract {

    interface MvpView {
        fun showMovies(movieList: List<MvpMovie>)
        fun noMoviesFound()
        fun showError(message: String)
    }

    interface MvpPresenter {
        fun fetchMovies()
    }
}