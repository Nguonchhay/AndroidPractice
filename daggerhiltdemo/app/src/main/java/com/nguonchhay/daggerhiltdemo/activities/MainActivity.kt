package com.nguonchhay.daggerhiltdemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguonchhay.daggerhiltdemo.adapters.CryptoCurrencyAdapter
import com.nguonchhay.daggerhiltdemo.databinding.ActivityMainBinding
import com.nguonchhay.daggerhiltdemo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeCryptoCurrency()
    }

    private fun observeCryptoCurrency() {
        mainViewModel.cryptoCurrency.observe(this, Observer {
            binding.rvCryptoCurrency.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvCryptoCurrency.adapter = CryptoCurrencyAdapter(it)
        })
    }
}