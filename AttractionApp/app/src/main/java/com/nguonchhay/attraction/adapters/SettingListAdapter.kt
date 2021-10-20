package com.nguonchhay.attraction.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databases.data.SettingItem

class SettingListAdapter(val appContext: Activity, val listData: MutableList<SettingItem>)
    : ArrayAdapter<SettingItem>(appContext, R.layout.list_setting_items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(appContext).inflate(R.layout.list_setting_items, null)

        val settingItem = listData.get(position)
        val imageView = view.findViewById<ImageView>(R.id.settingImage)
        imageView.setImageResource(settingItem.image)

        val titleView = view.findViewById<TextView>(R.id.settingTitle)
        titleView.text = settingItem.title

        return view
    }
}