package com.example.androidapparchitecture.mvp.presenter

import com.example.androidapparchitecture.mvp.contract.MvpMovieContract
import com.example.androidapparchitecture.mvp.model.MvpDataModel

class MvpMoviePresenter(private val view: MvpMovieContract.MvpView): MvpMovieContract.MvpPresenter {

    private val dataModel = MvpDataModel()

    override fun fetchMovies() {
        val movieList = dataModel.getMovies()

        if (movieList.isNotEmpty()) {
            view.showMovies(movieList)
        } else {
            view.noMoviesFound()
        }
    }
}