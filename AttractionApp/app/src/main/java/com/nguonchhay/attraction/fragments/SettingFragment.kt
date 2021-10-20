package com.nguonchhay.attraction.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.adapters.SettingListAdapter
import com.nguonchhay.attraction.databases.data.SettingItem

class SettingFragment(val context: Activity) : Fragment(R.layout.fragment_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listData = mutableListOf<SettingItem>(
            SettingItem(R.drawable.icon_home, "Home"),
            SettingItem(R.drawable.icon_attraction, "Attraction"),
            SettingItem(R.drawable.icon_setting, "Setting")
        )
        val adapter = SettingListAdapter(context, listData)
        val listView: ListView = view.findViewById(R.id.listSettingFragment)
        listView.isClickable = true
        listView.adapter = adapter
    }
}