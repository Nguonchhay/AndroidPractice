package com.nguonchhay.daggerhiltdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nguonchhay.daggerhiltdemo.data_class.CryptoCurrency
import com.nguonchhay.daggerhiltdemo.repositories.ICryptoCurrentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptoCurrentRepository: ICryptoCurrentRepository
) : ViewModel() {

    private val cryptoCurrencyEmitter = MutableLiveData<List<CryptoCurrency>>()
    val cryptoCurrency: LiveData<List<CryptoCurrency>> = cryptoCurrencyEmitter

    init {
        loadCryptoCurrencies()
    }

    private fun loadCryptoCurrencies() {
        cryptoCurrencyEmitter.value = cryptoCurrentRepository.getCryptoCurrencies()
    }
}