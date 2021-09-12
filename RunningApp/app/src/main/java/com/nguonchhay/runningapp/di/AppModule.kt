package com.nguonchhay.runningapp.di

import android.content.Context
import androidx.room.Room
import com.nguonchhay.runningapp.databases.RunDatabase
import com.nguonchhay.runningapp.others.Constants.RUN_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(app, RunDatabase::class.java, RUN_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideRunningDao(db: RunDatabase) = db.getRunDao()
}