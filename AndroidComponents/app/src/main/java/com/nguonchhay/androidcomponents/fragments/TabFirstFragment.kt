package com.nguonchhay.androidcomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nguonchhay.androidcomponents.R

/**
 * A simple [Fragment] subclass.
 * Use the [TabFirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabFirstFragment : Fragment(R.layout.fragment_tab_first) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}