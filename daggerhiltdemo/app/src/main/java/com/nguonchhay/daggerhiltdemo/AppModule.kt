package com.nguonchhay.daggerhiltdemo

import com.nguonchhay.daggerhiltdemo.repositories.CryptoCurrencyRepositoryImpl
import com.nguonchhay.daggerhiltdemo.repositories.ICryptoCurrentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCryptoCurrencyRepository(): ICryptoCurrentRepository = CryptoCurrencyRepositoryImpl()
}