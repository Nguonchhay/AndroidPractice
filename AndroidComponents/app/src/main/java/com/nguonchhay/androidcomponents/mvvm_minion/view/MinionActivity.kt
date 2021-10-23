package com.nguonchhay.androidcomponents.mvvm_minion.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nguonchhay.androidcomponents.databinding.ActivityMinionBinding
import com.nguonchhay.androidcomponents.mvvm_minion.viewmodel.MinionViewModel

class MinionActivity : AppCompatActivity() {

    lateinit var binding: ActivityMinionBinding
    private val minionViewModel: MinionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMinionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        minionViewModel.getMinionState().observe(this, Observer { minion ->
            binding.minionImage.setImageResource(minion.image)
            binding.minionName.text = minion.name
        })
    }
}