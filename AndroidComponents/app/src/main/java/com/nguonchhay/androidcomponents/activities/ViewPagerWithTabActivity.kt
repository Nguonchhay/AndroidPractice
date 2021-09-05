package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.adapters.ViewPager2Adapter
import com.nguonchhay.androidcomponents.databinding.ActivityViewPager2Binding
import com.nguonchhay.androidcomponents.databinding.ActivityViewPagerWithTabBinding

class ViewPagerWithTabActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewPagerWithTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerWithTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = mutableListOf<Int>(
            R.drawable.minion1,
            R.drawable.minion2,
            R.drawable.minion3,
            R.drawable.minion4,
            R.drawable.minion5,
        )
        val adapter = ViewPager2Adapter(imageList)
        binding.viewPagerWithTab.adapter = adapter

        // Connect TabLayout with ViewPage2
        TabLayoutMediator(binding.tabLayout, binding.viewPagerWithTab) { tab, position ->
            tab.text = "Item ${position + 1}"
        }.attach()

        // Add even to TabLayout
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}