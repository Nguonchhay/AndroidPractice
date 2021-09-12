package com.nguonchhay.runningapp.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nguonchhay.runningapp.databases.DAO.RunDAO
import com.nguonchhay.runningapp.databases.models.Run

@Database(entities = [Run::class], version = 1, exportSchema = false)
@TypeConverters(BitmapConverter::class)
abstract class RunDatabase : RoomDatabase() {
    abstract fun getRunDao(): RunDAO
}