package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.androidcomponents.databinding.ActivityCardViewBinding

class CardViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}