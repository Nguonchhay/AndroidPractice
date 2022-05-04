package com.nguonchhay.daggerhiltdemo.repositories

import com.nguonchhay.daggerhiltdemo.data_class.CryptoCurrency

interface ICryptoCurrentRepository {

    fun getCryptoCurrencies(): List<CryptoCurrency>

}