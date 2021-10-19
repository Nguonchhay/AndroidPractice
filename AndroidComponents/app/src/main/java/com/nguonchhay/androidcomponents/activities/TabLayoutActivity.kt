package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
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
        fragments.add(TabFirstFragment())
        fragments.add(TabFirstFragment())
        val tabAdapter = TabFragmentAdapter(fragments, supportFragmentManager, lifecycle)
        binding.viewPagerTabFragment.adapter = tabAdapter

        TabLayoutMediator(binding.tabLayoutActivity, binding.viewPagerTabFragment) {tab, position ->
            tab.text = "Fragment ${position + 1}"
        }.attach()

        /**
         * Change direction
         *
         * doppelgangerViewPager.layoutDirection = ViewPager2.LAYOUT_DIRECTION_RTL
         * tabLayout.layoutDirection = View.LAYOUT_DIRECTION_RTL
         */

        binding.viewPagerTabFragment.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Toast.makeText(this@TabLayoutActivity, "Selected position: $position",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }
}