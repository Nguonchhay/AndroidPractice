package com.nguonchhay.attraction.rooms.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nguonchhay.attraction.rooms.UserEntityInterface
import kotlinx.serialization.Serializable

@Entity(tableName = "users")
class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String? = null,

    @ColumnInfo(name = "name")
    val name: String ? = null
): UserEntityInterface