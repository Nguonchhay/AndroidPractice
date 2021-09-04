package com.nguonchhay.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nguonchhay.androidcomponents.databinding.ActivityMainBinding
import com.nguonchhay.androidcomponents.fragments.FirstFragment
import com.nguonchhay.androidcomponents.fragments.SecondFragment
import com.nguonchhay.androidcomponents.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set FirstFragment as default
        replaceFragment(FirstFragment())

        binding.btnFirst.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.btnSecond.setOnClickListener {
            replaceFragment(SecondFragment())
        }

        binding.btnThird.setOnClickListener {
            replaceFragment(ThirdFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}