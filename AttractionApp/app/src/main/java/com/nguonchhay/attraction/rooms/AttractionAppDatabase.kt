package com.nguonchhay.attraction.rooms

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nguonchhay.attraction.rooms.dao.UserDao
import com.nguonchhay.attraction.rooms.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AttractionAppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: AttractionAppDatabase? = null

        fun getInstance(context: Context): AttractionAppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AttractionAppDatabase::class.java,
                        "attractiondb"
                    )
                    .allowMainThreadQueries()
                    .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}