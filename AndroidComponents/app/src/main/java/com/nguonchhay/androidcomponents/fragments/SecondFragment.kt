package com.nguonchhay.androidcomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.FragmentSecondBinding

class SecondFragment(var myText: String? = null) : Fragment(R.layout.fragment_second) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.text2.text = arguments?.getString("F2_TEXT")

        return binding.root
    }
}