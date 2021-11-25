package com.nguonchhay.attraction.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.utils.SharedPreferenceUtil

class HomeFragment(val appContext: Context) : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preference  = SharedPreferenceUtil(appContext)
        val sampleText: TextView = view.findViewById(R.id.fragmentHomeText)
        sampleText.text = preference.getItem("ACCESS_TOKEN")
    }
}