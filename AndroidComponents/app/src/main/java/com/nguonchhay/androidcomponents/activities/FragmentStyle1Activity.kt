package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityFragmentStyle1Binding
import com.nguonchhay.androidcomponents.fragments.FirstFragment
import com.nguonchhay.androidcomponents.fragments.SecondFragment
import com.nguonchhay.androidcomponents.fragments.ThirdFragment

class FragmentStyle1Activity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentStyle1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentStyle1Binding.inflate(layoutInflater)
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
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}