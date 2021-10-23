package com.nguonchhay.androidcomponents.mvvm_minion.model

import com.nguonchhay.androidcomponents.R

class MinionProvider {
    private val minions = arrayListOf<Minion>()

    init {
        minions.add(Minion(R.drawable.minion1, "Minion 1"))
        minions.add(Minion(R.drawable.minion2, "Minion 2"))
        minions.add(Minion(R.drawable.minion3, "Minion 3"))
        minions.add(Minion(R.drawable.minion4, "Minion 4"))
        minions.add(Minion(R.drawable.minion5, "Minion 5"))
    }

    fun getMinions() = minions
}