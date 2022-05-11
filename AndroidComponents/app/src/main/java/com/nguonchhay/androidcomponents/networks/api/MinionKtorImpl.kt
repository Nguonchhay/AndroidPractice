package com.nguonchhay.androidcomponents.networks.api

import android.text.method.TextKeyListener
import android.util.Log
import com.nguonchhay.androidcomponents.dataclasses.MinionData
import com.nguonchhay.androidcomponents.networks.ApiRoute
import com.nguonchhay.androidcomponents.networks.model.MinionResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class MinionKtorImpl(private val client: HttpClient) : MinionKtorInterface {
    override suspend fun list(): MinionResponse {
        return try {
            client.get {
                url(ApiRoute.API_MINIONS_LIST)
            }
        } catch (e: RedirectResponseException) {
            // 3.x
            Log.d("MinionKtorImpl", "Error 3.xx: ${e.response.status.description}")
            MinionResponse(false, emptyList())
        } catch(e: ClientRequestException) {
            // 4.xx response
            Log.d("MinionKtorImpl" ,"Error 4.xx: ${e.response.status.description}")
            MinionResponse(false, emptyList())
        } catch(e: ServerResponseException) {
            // 5.xx response
            Log.d("MinionKtorImpl" ,"Error 5.xx: ${e.response.status.description}")
            MinionResponse(false, emptyList())
        } catch(e: Exception) {
            // other
            Log.d("MinionKtorImpl" ,"Error: ${e.message}")
            MinionResponse(false, emptyList())
        }
    }

    override suspend fun store(minion: MinionData): MinionResponse {
        return try {
            client.post {
                url(ApiRoute.API_MINIONS_LIST)
                contentType(ContentType.Application.Json)
                body = minion
            }
        } catch(e: Exception) {
            // other
            Log.d("MinionKtorImpl" ,"Error: ${e.message}")
            MinionResponse(false, emptyList())
        }
    }

    override suspend fun update(id: Int, minion: MinionData): MinionResponse {
        return try {
            client.request {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "nguonchhay.free.beeceptor.com"
                    path("api/minions", id.toString(), "update")
                }
                headers {
                    append("Content-Type", "application/json")
                }

                method = HttpMethod.Put
                body = minion
            }
        } catch(e: Exception) {
            // other
            Log.d("MinionKtorImpl" ,"Error: ${e.message}")
            MinionResponse(false, emptyList())
        }
    }
}