package com.nguonchhay.androidcomponents.jetpack_composes.viewmodels

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var resultState = mutableStateOf(0.0)

    fun doSum(value1: Double, value2: Double) {
        resultState.value = value1 + value2
    }

    fun doMinus(value1: Double, value2: Double) {
        resultState.value = value1 - value2
    }
    fun doMul(value1: Double, value2: Double) {
        resultState.value = value1 * value2
    }
}

val CalculatorState = compositionLocalOf<CalculatorViewModel> {
    error("Calculator Context is not found.")
}