package com.nguonchhay.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.firstapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToMain.setOnClickListener {
            super.finish()
        }
    }
}