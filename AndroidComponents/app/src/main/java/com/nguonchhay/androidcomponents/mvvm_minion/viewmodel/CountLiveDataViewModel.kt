package com.nguonchhay.androidcomponents.mvvm_minion.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountLiveDataViewModel : ViewModel() {

    private val delay = 1000L
    private var isAuto: Boolean = false
    private var count: Int = 0

    val uiState = MutableLiveData<CountData>()

    data class CountData(var count: Int = 0)

    init {
        uiState.value = CountData(count)
    }

    fun increase() {
        count++
        uiState.value = CountData(count)
    }

    fun decrease() {
        count--
        uiState.value = CountData(count)
    }

    private fun loopTheCount() {
        Handler(Looper.getMainLooper()).postDelayed(
            { startTheLoopCount() },
            delay
        )
    }

    private fun startTheLoopCount() {
        if (isAuto) {
            increase()
            loopTheCount()
        }
    }

    fun toggleAuto() {
        this.isAuto = !isAuto
        loopTheCount()
    }
}