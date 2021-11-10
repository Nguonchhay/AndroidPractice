package com.nguonchhay.attraction.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.nguonchhay.attraction.databinding.ActivityAttractionBinding
import com.nguonchhay.attraction.networks.ApiAttractionInterface
import com.nguonchhay.attraction.networks.ApiUtil
import kotlinx.coroutines.launch

class AttractionActivity : AppCompatActivity() {

    lateinit var binding: ActivityAttractionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttractionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        Log.d("attraction_detail", "Detail: " + bundle!!.getInt("ATTRACTION_ID"))
        lifecycleScope.launch {
            try {
                val attractionApi = ApiUtil.getInstance().create(ApiAttractionInterface::class.java)
                val  attractionId:Int = bundle!!.getInt("ATTRACTION_ID")
                val result = attractionApi.show(attractionId)
                if (result.isSuccessful) {
                    val attraction = result.body()
                    binding.attractionDetailTitle.text = attraction?.title
                    binding.attractionDetailDescription.text = attraction?.description
                    Glide.with(this@AttractionActivity).load(attraction?.image).into(binding.attractionDetailImage)
                }
            } catch(e: Exception) {
                Log.d("attraction_detail", "ERROR: ${e.toString()}")
            }
        }
    }
}