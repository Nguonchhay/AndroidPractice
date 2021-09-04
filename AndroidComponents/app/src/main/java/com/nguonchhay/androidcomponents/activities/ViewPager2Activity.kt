package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.adapters.ViewPager2Adapter
import com.nguonchhay.androidcomponents.databinding.ActivityViewPager2Binding

class ViewPager2Activity : AppCompatActivity() {

    lateinit var binding: ActivityViewPager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = mutableListOf<Int>(
            R.drawable.minion1,
            R.drawable.minion2,
            R.drawable.minion3,
            R.drawable.minion4,
            R.drawable.minion5,
        )
        val adapter = ViewPager2Adapter(imageList)
        binding.viewPager2.adapter = adapter

        // Vertical swap
        // binding.viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
    }
}