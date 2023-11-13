package com.example.androidapparchitecture.mvi.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.androidapparchitecture.common.ui.model.MovieUiModel
import com.example.androidapparchitecture.mvi.base.BaseMviViewModel
import com.example.androidapparchitecture.mvi.contract.MviContract
import com.example.androidapparchitecture.mvvm.model.repository.MovieRepository
import kotlinx.coroutines.launch

class MviViewModel: BaseMviViewModel<MviContract.MviState,MviContract.MviIntent, MviContract.MviEffect>() {

    private val movieRepository: MovieRepository = MovieRepository()

    override fun setInitialState() = MviContract.MviState.Idle

    override fun handleIntent(intent: MviContract.MviIntent) {
        when(intent) {
            MviContract.MviIntent.LoadMovies -> {
                setState {
                    MviContract.MviState.Loading
                }
                fetchMovies()
            }
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {

            val movies = movieRepository.getMovies().movies.map {
                MovieUiModel(
                    title = it.title,
                    poster = it.poster,
                    year = it.year
                )
            }

            setState {
                MviContract.MviState.Success(movies)
            }

            setEffect {
                MviContract.MviEffect.MoviesLoaded
            }
        }
    }
}