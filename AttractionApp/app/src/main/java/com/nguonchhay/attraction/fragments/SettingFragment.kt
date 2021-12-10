package com.nguonchhay.attraction.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.activities.AdminAttractionActivity
import com.nguonchhay.attraction.activities.LoginActivity
import com.nguonchhay.attraction.adapters.SettingListAdapter
import com.nguonchhay.attraction.databases.data.SettingItem
import com.nguonchhay.attraction.utils.SharedPreferenceUtil

class SettingFragment(val context: Activity) : Fragment(R.layout.fragment_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listData = mutableListOf<SettingItem>(
            SettingItem(R.drawable.icon_home, "Home"),
            SettingItem(R.drawable.icon_attraction, "Attraction"),
            SettingItem(R.drawable.icon_setting, "Setting"),
            SettingItem(R.drawable.icon_logout, "Logout")
        )
        val adapter = SettingListAdapter(context, listData)
        val listView: ListView = view.findViewById(R.id.listSettingFragment)
        listView.isClickable = true
        listView.adapter = adapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            if (listData[i].title == "Logout") {
                val preference = SharedPreferenceUtil(context)
                preference.storeItem("ACCESS_TOKEN", "")
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
            } else if (listData[i].title == "Attraction")  {
                startActivity(Intent(context, AdminAttractionActivity::class.java))
            }
        }
    }
}