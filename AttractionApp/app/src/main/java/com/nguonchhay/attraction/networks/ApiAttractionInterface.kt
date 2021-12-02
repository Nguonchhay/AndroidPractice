package com.nguonchhay.attraction.networks

import com.nguonchhay.attraction.databases.data.AttractionItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

class Attractions: ArrayList<AttractionItem>()

interface ApiAttractionInterface {

    @GET("/api/attractions")
    @Headers("Accept:application/json", "Content-Type:application/json")
    suspend fun list(): Response<Attractions>

    @GET("/Nguonchhay/attraction-fake-api/attractions/{id}")
    @Headers("Accept:application/json", "Content-Type:application/json")
    suspend fun show(@Path(value = "id", encoded = true) id: Int): Response<AttractionItem>
}