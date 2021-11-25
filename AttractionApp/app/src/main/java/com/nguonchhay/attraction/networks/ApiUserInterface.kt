package com.nguonchhay.attraction.networks

import com.nguonchhay.attraction.databases.data.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiUserInterface {

    @POST("/api/login")
    @Headers("Content-Type:application/json")
    suspend fun login(@Body userData: UserData): Response<Any>
}