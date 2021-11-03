package com.nguonchhay.attraction.networks

import com.nguonchhay.attraction.databases.data.AttractionItem
import retrofit2.Response
import retrofit2.http.GET

class Attractions: ArrayList<AttractionItem>()

interface ApiAttractionInterface {

    @GET("/Nguonchhay/attraction-fake-api/attractions")
    suspend fun list(): Response<Attractions>
}