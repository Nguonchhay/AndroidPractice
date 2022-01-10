package com.nguonchhay.attraction.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.attraction.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoogleMap.setOnClickListener {
            startActivity(Intent(this, GoogleMapActivity::class.java))
        }
    }
}