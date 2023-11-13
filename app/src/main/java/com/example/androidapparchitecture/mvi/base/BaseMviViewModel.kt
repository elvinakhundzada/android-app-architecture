package com.example.androidapparchitecture.mvi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseMviViewModel<S: UiState, I: UiIntent, E: UiEffect>: ViewModel() {

    private val initialState by lazy {
        setInitialState()
    }

    val uiState: MutableStateFlow<S> = MutableStateFlow(initialState)

    val uiEffect = MutableSharedFlow<E>()

    abstract fun setInitialState(): S

    abstract fun handleIntent(intent: I)

    protected fun setEffect(builder: () -> E) {
        val effectValue = builder()
        viewModelScope.launch {
            uiEffect.emit(effectValue)
        }
    }

    protected fun setState(builder: () -> S) {
        val stateValue = builder()
        viewModelScope.launch {
            uiState.emit(stateValue)
        }
    }}