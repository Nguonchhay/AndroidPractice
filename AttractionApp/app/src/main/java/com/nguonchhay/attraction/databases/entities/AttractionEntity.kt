package com.nguonchhay.attraction.databases.entities

import kotlinx.serialization.Serializable

@Serializable
class AttractionEntity(
    val id: Int? = null,

    val image: String,

    val title: String,

    val description: String ? = null
)