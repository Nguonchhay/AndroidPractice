package com.nguonchhay.androidcomponents.dataclasses.dao

import android.database.Cursor
import androidx.room.*
import com.nguonchhay.androidcomponents.dataclasses.entities.Contact


@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun storeContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getContacts(): Cursor

    @Query("SELECT * FROM contacts WHERE id=:id")
    fun getContact(id: Long): Contact
}