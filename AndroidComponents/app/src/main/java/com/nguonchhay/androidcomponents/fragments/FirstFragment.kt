package com.nguonchhay.androidcomponents.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

//        val textField = view.findViewById<TextView>(R.id.text1)
//        textField.text = arguments?.getString("F1_TEXT")
        val text = arguments?.getString("F1_TEXT").toString() + " binding"
        binding.text1.text = text
    }
}