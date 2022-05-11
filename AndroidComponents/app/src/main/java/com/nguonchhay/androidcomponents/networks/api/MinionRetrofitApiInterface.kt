package com.nguonchhay.androidcomponents.networks.api

import com.nguonchhay.androidcomponents.dataclasses.MinionCardData
import com.nguonchhay.androidcomponents.networks.model.MinionRawResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface MinionRetrofitApiInterface {

    @GET("/api/minions")
    @Headers("Content-Type:application/json")
    suspend fun list(): Response<MinionRawResponse>

    @POST("/api/minions")
    @Headers("Content-Type:application/json")
    suspend fun store(@Body minion: MinionCardData): Response<MinionRawResponse>

    @PUT("/api/minions/{id}/update")
    @Headers("Content-Type:application/json")
    suspend fun update(@Path("id") id: Int , @Body minion: MinionCardData): Response<MinionRawResponse>
}