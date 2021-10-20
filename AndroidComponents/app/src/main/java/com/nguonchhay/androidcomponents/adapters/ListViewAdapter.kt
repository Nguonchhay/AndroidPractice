package com.nguonchhay.androidcomponents.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.dataclasses.ListViewData

class ListViewAdapter(
    val context: Activity,
    val listData: MutableList<ListViewData>
) : ArrayAdapter<ListViewData>(context, R.layout.listview_item, listData) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        val item = listData[position]
        val imageView = view.findViewById<ImageView>(R.id.lsvImage)
        imageView.setImageResource(item.image)

        val titleView = view.findViewById<TextView>(R.id.lsvTitle)
        titleView.text = item.title

        return view
    }
}