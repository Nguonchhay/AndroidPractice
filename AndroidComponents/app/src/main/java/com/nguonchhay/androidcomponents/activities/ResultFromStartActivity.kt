package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.androidcomponents.databinding.ActivityResultFromStartBinding

class ResultFromStartActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultFromStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultFromStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}