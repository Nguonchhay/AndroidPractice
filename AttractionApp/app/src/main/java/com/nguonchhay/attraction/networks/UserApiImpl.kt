package com.nguonchhay.attraction.networks

import android.util.Log
import com.nguonchhay.attraction.databases.entities.AttractionEntity
import com.nguonchhay.attraction.rooms.entities.UserEntity as DBUserEntity
import com.nguonchhay.attraction.databases.entities.UserEntity as RequestUserEntity
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class UserApiImpl(
    private val client: HttpClient
) : UserApi {

    override suspend fun login(user: RequestUserEntity): RequestUserEntity {
        return try {
            client.post<RequestUserEntity> {
                url(HttpRoutes.USER_LOGIN)
                contentType(ContentType.Application.Json)
                body = user
            }
        } catch(e: RedirectResponseException) {
            // 3.xx response
            Log.d("UserApiImpl" ,"Error 3.xx: ${e.response.status.description}")
            user
        } catch(e: ClientRequestException) {
            // 4.xx response
            Log.d("UserApiImpl" ,"Error 4.xx: ${e.response.status.description}")
            user
        } catch(e: ServerResponseException) {
            // 5.xx response
            Log.d("UserApiImpl" ,"Error 5.xx: ${e.response.status.description}")
            user
        } catch(e: Exception) {
            // 5.xx response
            Log.d("UserApiImpl" ,"Error: ${e.message}")
            user
        }
    }

    override suspend fun list(): List<RequestUserEntity> {
        return try {
            client.get { url(HttpRoutes.USERS) }
        } catch(e: RedirectResponseException) {
            // 3.xx response
            Log.d("UserApiImpl" ,"Error 3.xx: ${e.response.status.description}")
            emptyList<RequestUserEntity>()
        } catch(e: ClientRequestException) {
            // 4.xx response
            Log.d("UserApiImpl" ,"Error 4.xx: ${e.response.status.description}")
            emptyList<RequestUserEntity>()
        } catch(e: ServerResponseException) {
            // 5.xx response
            Log.d("UserApiImpl" ,"Error 5.xx: ${e.response.status.description}")
            emptyList<RequestUserEntity>()
        } catch(e: Exception) {
            // 5.xx response
            Log.d("UserApiImpl" ,"Error: ${e.message}")
            emptyList<RequestUserEntity>()
        }
    }
}