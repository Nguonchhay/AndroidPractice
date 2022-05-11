package com.nguonchhay.androidcomponents.networks.model

import com.nguonchhay.androidcomponents.dataclasses.MinionCardData

data class MinionRawResponse(
    val success: Boolean,
    val data: List<MinionCardData>
)
