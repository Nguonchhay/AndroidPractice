package com.nguonchhay.attraction.rooms.dao

import androidx.room.*
import com.nguonchhay.attraction.rooms.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    fun store(user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun remove(user: UserEntity)

    @Query("SELECT * FROM users")
    fun list(): List<UserEntity>
}