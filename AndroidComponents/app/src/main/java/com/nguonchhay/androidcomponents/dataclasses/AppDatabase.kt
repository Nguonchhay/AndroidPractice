package com.nguonchhay.androidcomponents.dataclasses

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nguonchhay.androidcomponents.dataclasses.dao.ContactDao
import com.nguonchhay.androidcomponents.dataclasses.entities.Contact


@Database(entities = [Contact::class], version = AppDatabase.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDAO(): ContactDao

    companion object {
        private const val DB_NAME = "contactmanager"
        const val DB_VERSION = 1

        @Volatile
        private var instance: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, AppDatabase.DB_NAME).build()
                    }
                }
            }
            return instance!!
        }
    }
}