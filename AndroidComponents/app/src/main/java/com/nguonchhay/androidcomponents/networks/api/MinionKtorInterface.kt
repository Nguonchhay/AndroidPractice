package com.nguonchhay.androidcomponents.networks.api

import com.nguonchhay.androidcomponents.dataclasses.MinionData
import com.nguonchhay.androidcomponents.networks.KtorClient
import com.nguonchhay.androidcomponents.networks.model.MinionResponse

interface MinionKtorInterface {
    suspend fun list(): MinionResponse
    suspend fun store(minion: MinionData): MinionResponse
    suspend fun update(id: Int, minion: MinionData): MinionResponse

    companion object {
        fun create(): MinionKtorImpl {
            return MinionKtorImpl(KtorClient.getClient())
        }
    }
}