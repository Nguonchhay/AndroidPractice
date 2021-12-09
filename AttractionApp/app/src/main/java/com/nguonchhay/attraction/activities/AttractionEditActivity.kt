package com.nguonchhay.attraction.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.attraction.databases.entities.AttractionEntity
import com.nguonchhay.attraction.databinding.ActivityAttractionEditBinding
import com.nguonchhay.attraction.networks.AttractionApi
import kotlinx.coroutines.launch

class AttractionEditActivity : AppCompatActivity() {

    lateinit var binding: ActivityAttractionEditBinding

    private val attractionApi = AttractionApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttractionEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdateAttraction.setOnClickListener {
            lifecycleScope.launch {
                val result = attractionApi.edit(
                    1,
                    AttractionEntity(
                        image = "https://example",
                        title = "Example attraction"
                    )
                )
                Log.d("AttractionEditActivity", "Data ${result.title}")
            }
        }
    }
}