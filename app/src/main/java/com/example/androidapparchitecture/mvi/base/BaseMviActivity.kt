package com.example.androidapparchitecture.mvi.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseMviActivity<S : UiState, I : UiIntent, E : UiEffect, VM : BaseMviViewModel<S, I, E>> :
    AppCompatActivity() {

    val viewModel by lazy {
        setupViewModel()
    }

    abstract fun setupViewModel(): VM //TODO Optimize ?
    abstract fun invalidateState(state: S)
    abstract fun invalidateEffect(effect: E)
    override fun onStart() {
        super.onStart()
        setupCollectors()
    }

    private fun setupCollectors() {
        viewModel.uiState
            .onEach {
                invalidateState(it)
            }.launchIn(lifecycleScope)

        viewModel.uiEffect
            .onEach {
                invalidateEffect(it)
            }.launchIn(lifecycleScope)
    }
}