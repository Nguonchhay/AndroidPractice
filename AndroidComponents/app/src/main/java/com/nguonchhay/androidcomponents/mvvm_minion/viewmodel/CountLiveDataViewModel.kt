package com.nguonchhay.androidcomponents.mvvm_minion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountLiveDataViewModel : ViewModel() {

    val _uiState = MutableLiveData<Int>()
    var uiState: Int = 0

    fun increase() {
        uiState++
        _uiState.value = uiState
    }

    fun decrease() {
        uiState--
        _uiState.value = uiState
    }
}