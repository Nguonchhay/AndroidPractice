package com.nguonchhay.attraction.databases.di

import com.google.gson.Gson
import com.nguonchhay.attraction.databases.interfaces.AttractionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAttractionApi(): AttractionApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://localhost:3000")
            .build()
            .create(AttractionApi::class.java)
    }
}