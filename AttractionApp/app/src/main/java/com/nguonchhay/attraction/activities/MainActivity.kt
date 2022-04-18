package com.nguonchhay.attraction.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databinding.ActivityMainBinding
import com.nguonchhay.attraction.fragments.AttractionFragment
import com.nguonchhay.attraction.fragments.HomeFragment
import com.nguonchhay.attraction.fragments.SettingFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment(this)
        val attractionFragment = AttractionFragment(this)
        val settingFragment = SettingFragment(this)

        setFragment(homeFragment)
        setBarTitle("Attraction App")

        // Add badge
        val badge = binding.bottomNavMain.getOrCreateBadge(R.id.menuAttraction)
        badge.number = 5

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
                R.id.menuMap -> {
                    startActivity(Intent(this@MainActivity, MapsActivity::class.java))
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