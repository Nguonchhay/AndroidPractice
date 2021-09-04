package com.nguonchhay.androidcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.androidcomponents.activities.FragmentStyle1Activity
import com.nguonchhay.androidcomponents.activities.RecyclerViewActivity
import com.nguonchhay.androidcomponents.activities.ViewPager2Activity
import com.nguonchhay.androidcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragmentStyle1.setOnClickListener {
            val intent = Intent(this, FragmentStyle1Activity::class.java)
            startActivity(intent)
        }

        binding.btnRecycleview.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewPager2.setOnClickListener {
            val intent = Intent(this, ViewPager2Activity::class.java)
            startActivity(intent)
        }
    }
}