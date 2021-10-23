package com.nguonchhay.androidcomponents.mvvm_minion.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nguonchhay.androidcomponents.mvvm_minion.model.Minion
import com.nguonchhay.androidcomponents.mvvm_minion.model.MinionProvider

class MinionViewModel: ViewModel() {

    private val minionState = MutableLiveData<Minion>()
    private val minionData = MinionProvider().getMinions()
    private var curIndex = 0
    private val delay = 1000L

    init {
        loop()
    }

    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed({ updateMinion() }, delay)
    }

    private fun updateMinion() {
        curIndex++
        curIndex %= minionData.size

        minionState.value = minionData[curIndex]

        loop()
    }

    fun getMinionState(): LiveData<Minion> = minionState
}