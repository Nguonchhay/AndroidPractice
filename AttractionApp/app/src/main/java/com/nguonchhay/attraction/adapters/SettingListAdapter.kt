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

class SettingListAdapter(
    val context: Activity, val listData: MutableList<SettingItem>
) : ArrayAdapter<SettingItem>(context, R.layout.list_setting_items, listData) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.list_setting_items, null)

        val settingItem = listData.get(position)
        val imageView = view.findViewById<ImageView>(R.id.settingImage)
        imageView.setImageResource(settingItem.image)

        val titleView = view.findViewById<TextView>(R.id.settingTitle)
        titleView.text = settingItem.title

        return view
    }
}