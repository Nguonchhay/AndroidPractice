package com.nguonchhay.androidcomponents.mvvm_minion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {

    var map = mutableMapOf<String, String>()
    private val _uiState = MutableStateFlow<CalculatorState>(CalculatorState())
    var uiState = _uiState.asStateFlow()

    data class CalculatorState (
        val result: Double = 0.0,
        val method: String = ""
    )

    fun sum(x: Double, y: Double) {
        viewModelScope.launch {
            _uiState.value = CalculatorState(x + y, "SUM")
        }
    }

    fun mul(x: Double, y: Double) {
        viewModelScope.launch {
            _uiState.value = CalculatorState(x * y, "MUL")
        }
    }

    fun sub(x: Double, y: Double) {
        viewModelScope.launch {
            _uiState.value = CalculatorState(x - y, "SUB")
        }
    }
}