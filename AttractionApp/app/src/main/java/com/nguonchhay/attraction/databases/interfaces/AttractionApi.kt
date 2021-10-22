package com.nguonchhay.attraction.databases.interfaces

import com.nguonchhay.attraction.databases.data.AttractionItem
import retrofit2.http.GET

interface AttractionApi {

    @GET("/attractions")
    suspend fun list(): MutableList<AttractionItem>

    @GET("/attractions/{id}")
    suspend fun show(id: Int): AttractionItem
}