package com.example.androidapparchitecture.mvi.contract

import com.example.androidapparchitecture.common.ui.model.MovieUiModel
import com.example.androidapparchitecture.mvi.base.UiEffect
import com.example.androidapparchitecture.mvi.base.UiIntent
import com.example.androidapparchitecture.mvi.base.UiState

object MviContract {
    sealed class MviState: UiState {
        object Idle: MviState()
        object Loading: MviState()
        data class Success(val movieList: List<MovieUiModel>): MviState()
        data class Error(val message: String): MviState()
    }
    sealed class MviIntent: UiIntent {
        object LoadMovies: MviIntent()
    }
    sealed class MviEffect: UiEffect {
        object MoviesLoaded: MviEffect()
    }
}