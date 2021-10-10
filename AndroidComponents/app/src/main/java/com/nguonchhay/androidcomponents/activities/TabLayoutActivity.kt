package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nguonchhay.androidcomponents.adapters.TabFragmentAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityTabLayoutBinding
import com.nguonchhay.androidcomponents.fragments.TabFirstFragment
import com.nguonchhay.androidcomponents.fragments.TabSecondFragment
import com.nguonchhay.androidcomponents.fragments.TabThirdFragment

class TabLayoutActivity : AppCompatActivity() {

    lateinit var binding: ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayoutActivity.addTab(
            binding.tabLayoutActivity.newTab().setText("Thursday")
        )

        val fragments = mutableListOf<Fragment>()
        fragments.add(TabFirstFragment())
        fragments.add(TabSecondFragment())
        fragments.add(TabThirdFragment())
        val tabAdapter = TabFragmentAdapter(fragments, supportFragmentManager, lifecycle)
        binding.viewPagerTabFragment.adapter = tabAdapter

        TabLayoutMediator(binding.tabLayoutActivity, binding.viewPagerTabFragment) {tab, position ->
            tab.text = "Fragment ${position + 1}"
        }.attach()

//        binding.tabLayoutActivity.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//        })
    }
}