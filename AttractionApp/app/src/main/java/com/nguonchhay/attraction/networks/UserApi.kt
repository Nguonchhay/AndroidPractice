package com.nguonchhay.attraction.networks

import com.nguonchhay.attraction.databases.entities.UserEntity
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface UserApi {
    suspend fun login(user: UserEntity): UserEntity
    suspend fun list(): List<UserEntity>

    companion object {
        fun create(): UserApiImpl {
            return UserApiImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }

                    install(JsonFeature)  {
                        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                            prettyPrint = true
                            isLenient = true
                        })
                    }
                }
            )
        }
    }
}