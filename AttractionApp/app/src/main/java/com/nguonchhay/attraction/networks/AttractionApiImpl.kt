package com.nguonchhay.attraction.networks

import android.util.Log
import com.nguonchhay.attraction.databases.entities.AttractionEntity
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import okhttp3.Response

class AttractionApiImpl(
    private val client: HttpClient
) :  AttractionApi {

    override suspend fun list(): List<AttractionEntity> {
        return try {
            client.get { url(HttpRoutes.ATTRACTIONS) }
        } catch(e: RedirectResponseException) {
            // 3.xx response
            Log.d("AttractionApiImpl" ,"Error 3.xx: ${e.response.status.description}")
            emptyList<AttractionEntity>()
        } catch(e: ClientRequestException) {
            // 4.xx response
            Log.d("AttractionApiImpl" ,"Error 4.xx: ${e.response.status.description}")
            emptyList<AttractionEntity>()
        } catch(e: ServerResponseException) {
            // 5.xx response
            Log.d("AttractionApiImpl" ,"Error 5.xx: ${e.response.status.description}")
            emptyList<AttractionEntity>()
        } catch(e: Exception) {
            // 5.xx response
            Log.d("AttractionApiImpl" ,"Error: ${e.message}")
            emptyList<AttractionEntity>()
        }
    }

    override suspend fun show(id: Int): AttractionEntity? {
        var requestId = id
        requestId = 1
        return try {
            // Mock up ID to equal 1 to match fake RESTful API
//            client.get {
//                url(HttpRoutes.ATTRACTIONS_SHOW)
//                parameter("id", requestId.toString())
//            }
            client.request<AttractionEntity> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "nguonchhay.free.beeceptor.com"
                    path("api/attractions", requestId.toString())
                }
            }
        } catch(e: RedirectResponseException) {
            // 3.xx response
            Log.d("AttractionApiImpl" ,"Error 3.xx: ${e.response.status.description}")
            null
        } catch(e: ClientRequestException) {
            // 4.xx response
            Log.d("AttractionApiImpl" ,"Error 4.xx: ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5.xx response
            Log.d("AttractionApiImpl" ,"Error 5.xx: ${e.response.status.description}")
            null
        } catch(e: Exception) {
            // 5.xx response
            Log.d("AttractionApiImpl" ,"Error: ${e.message}")
            null
        }
    }

    override suspend fun edit(id: Int, attraction: AttractionEntity): AttractionEntity {
        var requestId = id
        requestId = 1
        return try {
            client.request<AttractionEntity> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "nguonchhay.free.beeceptor.com"
                    path("api/attractions", requestId.toString())
                }
                headers {
                    append("Content-Type", "application/json")
                }
                //contentType(ContentType.Application.Json)
                method = HttpMethod.Put
                body = attraction
            }
        } catch(e: RedirectResponseException) {
            // 3.xx response
            Log.d("AttractionApiImpl" ,"Error 3.xx: ${e.response.status.description}")
            attraction
        } catch(e: ClientRequestException) {
            // 4.xx response
            Log.d("AttractionApiImpl" ,"Error 4.xx: ${e.response.status.description}")
            attraction
        } catch(e: ServerResponseException) {
            // 5.xx response
            Log.d("AttractionApiImpl" ,"Error 5.xx: ${e.response.status.description}")
            attraction
        } catch(e: Exception) {
            // 5.xx response
            Log.d("AttractionApiImpl" ,"Error: ${e.message}")
            attraction
        }
    }
}