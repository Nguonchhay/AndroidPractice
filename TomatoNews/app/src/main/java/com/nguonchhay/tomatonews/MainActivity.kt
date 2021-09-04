package com.nguonchhay.tomatonews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    var tabContainer: TabLayout? = null
    var fragmentContainer: ViewPager2? = null
    var fragmentAdapter: FragmentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabContainer = findViewById(R.id.tabContainer)
        fragmentContainer = findViewById(R.id.fragmentContainer)

        supportFragmentManager.commit {
            replace<ExampleFragment>(R.id.fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name") // name can be null
        }

        val fragment: ExampleFragment =
            supportFragmentManager.findFragmentByTag("tag") as ExampleFragment
    }
}