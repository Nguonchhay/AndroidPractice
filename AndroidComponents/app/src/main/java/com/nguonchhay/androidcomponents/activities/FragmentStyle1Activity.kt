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

        // Prepare First Fragment object
        val fragment = FirstFragment()
        val bundle = Bundle()
        bundle.putString("F1_TEXT", "Fragment 1 Content")
        fragment.arguments = bundle

        // Set FirstFragment as default
        replaceFragment(fragment)

        binding.btnFirst.setOnClickListener {
            replaceFragment(fragment)
        }

        binding.btnSecond.setOnClickListener {
            val fragment2 = SecondFragment()
            val bundle2 = Bundle()
            bundle2.putString("F2_TEXT", "Fragment 2 Content")
            fragment2.arguments = bundle2
            replaceFragment(fragment2)
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