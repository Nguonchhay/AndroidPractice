package com.nguonchhay.androidcomponents.networks.model

import com.nguonchhay.androidcomponents.dataclasses.MinionData
import kotlinx.serialization.Serializable

@Serializable
data class MinionResponse(
    val success: Boolean,
    val data: List<MinionData>
)
