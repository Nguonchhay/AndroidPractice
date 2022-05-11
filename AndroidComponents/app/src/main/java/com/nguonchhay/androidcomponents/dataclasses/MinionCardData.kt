package com.nguonchhay.androidcomponents.dataclasses

import com.google.gson.annotations.SerializedName

data class MinionCardData(
    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("image")
    var image: Int
)