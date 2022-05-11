package com.nguonchhay.androidcomponents.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class MinionData(
    var id: Int? = 0,

    var title: String,

    var description: String,

    var image: Int
)