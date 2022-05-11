package com.nguonchhay.androidcomponents.networks

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.HttpHeaders

private const val TIMEOUT = 180000L

class KtorClient {
    companion object {
        fun getClient(): HttpClient {
            return HttpClient(Android) {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }

//                install(HttpTimeout) {
//                    requestTimeoutMillis = TIMEOUT
//                    connectTimeoutMillis = TIMEOUT
//                    socketTimeoutMillis = TIMEOUT
//                }

                install(Logging) {
                    logger = object: Logger {
                        override fun log(message: String) {
                            Log.v("Logger ktor => ", message)
                        }
                    }
                    level = LogLevel.ALL
                }

                install(ResponseObserver) {
                    onResponse { response ->
                        Log.d("HTTP Status: ", "${response.status.value}")
                    }
                }

                install(DefaultRequest) {
                    header(HttpHeaders.ContentType, io.ktor.http.ContentType.Application.Json)
                }
            }
        }
    }

}
