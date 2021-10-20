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

class SettingFragment(val appContext: Activity) : Fragment(R.layout.fragment_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<SettingItem>(
            SettingItem(R.drawable.icon_home, "Home"),
            SettingItem(R.drawable.icon_attraction, "Attraction"),
            SettingItem(R.drawable.icon_setting, "Setting")
        )
        //val adapter = SettingListAdapter(appContext, list)
        val adapter =
            activity?.let { ArrayAdapter<SettingItem>(it, R.layout.list_setting_items, list) }
        val listView: ListView = view.findViewById(R.id.listSettingFragment)
        //listView.isClickable = true
        listView.adapter = adapter
//        listView.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(parent.context, "Click at ${position}", Toast.LENGTH_SHORT).show()
//        }
    }
}