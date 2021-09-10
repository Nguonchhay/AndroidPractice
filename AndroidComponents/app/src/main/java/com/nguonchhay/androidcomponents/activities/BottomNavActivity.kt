package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityBottomNavBinding
import com.nguonchhay.androidcomponents.fragments.BottomNavHomeFragment
import com.nguonchhay.androidcomponents.fragments.BottomNavMessageFragment
import com.nguonchhay.androidcomponents.fragments.BottomNavProfileFragment

class BottomNavActivity : AppCompatActivity() {

    lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = BottomNavHomeFragment()
        val messageFragment = BottomNavMessageFragment()
        val profileFragment = BottomNavProfileFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavContainer.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menuHome -> setCurrentFragment(homeFragment)
                R.id.menuMessage -> setCurrentFragment(messageFragment)
                R.id.menuProfile -> setCurrentFragment(profileFragment)
            }
            true
        }

        binding.bottomNavContainer.getOrCreateBadge(R.id.menuMessage).apply {
            number = 5
            isVisible = true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerBottomNav, fragment)
            commit()
        }
    }
}