package com.nguonchhay.androidcomponents.mvvm_minion.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.androidcomponents.databinding.ActivityCountLiveDataBinding
import com.nguonchhay.androidcomponents.mvvm_minion.viewmodel.CountLiveDataViewModel
import kotlinx.coroutines.launch

class CountLiveDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityCountLiveDataBinding
    lateinit var viewModel: CountLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CountLiveDataViewModel::class.java]

        binding.btnIncrease.setOnClickListener {
            viewModel.increase()
        }

        binding.btnDecrease.setOnClickListener {
            viewModel.decrease()
        }

        binding.btnAuto.setOnClickListener {
            viewModel.toggleAuto()
        }

        viewModel.uiState.observe(this@CountLiveDataActivity, Observer {
            binding.lblCount.text = it.count.toString()
        })

    }
}