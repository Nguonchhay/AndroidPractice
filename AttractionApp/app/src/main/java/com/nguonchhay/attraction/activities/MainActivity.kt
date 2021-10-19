package com.nguonchhay.attraction.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databinding.ActivityMainBinding
import com.nguonchhay.attraction.fragments.AttractionFragment
import com.nguonchhay.attraction.fragments.HomeFragment
import com.nguonchhay.attraction.fragments.SettingFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val attractionFragment = AttractionFragment()
        val settingFragment = SettingFragment()

        setFragment(homeFragment)

        binding.bottomNavMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menuHome -> setFragment(homeFragment)
                R.id.menuAttraction -> setFragment(attractionFragment)
                R.id.menuSetting -> setFragment(settingFragment)
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerMain, fragment)
            commit()
        }
    }
}