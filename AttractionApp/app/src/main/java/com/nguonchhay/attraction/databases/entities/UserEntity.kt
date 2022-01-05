package com.nguonchhay.attraction.databases.entities

import com.nguonchhay.attraction.rooms.UserEntityInterface
import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val id: Int? = null,
    val email: String,
    val password: String? = null,
    val name: String? = null
): UserEntityInterface
