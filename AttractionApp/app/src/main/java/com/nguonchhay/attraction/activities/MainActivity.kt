package com.nguonchhay.attraction.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.fragment.app.Fragment
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databinding.ActivityMainBinding
import com.nguonchhay.attraction.fragments.AttractionFragment
import com.nguonchhay.attraction.fragments.HomeFragment
import com.nguonchhay.attraction.fragments.SettingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContent {
            AttractionAppTheme
        }


        val homeFragment = HomeFragment(this)
        val attractionFragment = AttractionFragment(this)
        val settingFragment = SettingFragment(this)

        setFragment(homeFragment)
        setBarTitle("Attraction App")

        binding.bottomNavMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menuHome -> {
                    setFragment(homeFragment)
                    setBarTitle("Attraction App")
                }
                R.id.menuAttraction -> {
                    setFragment(attractionFragment)
                    setBarTitle(it.title.toString())
                }
                R.id.menuSetting -> {
                    setFragment(settingFragment)
                    setBarTitle(it.title.toString())
                }
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

    private fun setBarTitle(text: String) {
        binding.toolbarTitleMain.text = text
    }
}