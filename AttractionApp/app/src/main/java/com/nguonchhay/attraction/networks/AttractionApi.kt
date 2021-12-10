package com.nguonchhay.attraction.networks

import com.nguonchhay.attraction.databases.entities.AttractionEntity
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

interface AttractionApi {

    suspend fun list(): List<AttractionEntity>

    suspend fun show(id: Int): AttractionEntity?

    suspend fun edit(id: Int, attraction: AttractionEntity): AttractionEntity

    companion object {
        fun create(): AttractionApiImpl {
            return AttractionApiImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }

                    install(JsonFeature)  {
                        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                            prettyPrint = true
                            ignoreUnknownKeys = true
                        })
                    }
                }
            )
        }
    }
}