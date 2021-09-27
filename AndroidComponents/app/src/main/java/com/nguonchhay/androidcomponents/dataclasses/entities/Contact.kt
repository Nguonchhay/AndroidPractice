package com.nguonchhay.androidcomponents.dataclasses.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "contacts")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: Long?,

    @NotNull
    val name: String,

    @NotNull
    val phone: String
)
