package com.nguonchhay.androidcomponents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.nguonchhay.androidcomponents.R

class GridViewColorAdapter(val listColors: List<Pair<String, Int>>) : BaseAdapter() {

    override fun getCount(): Int {
        return listColors.size
    }

    override fun getItem(position: Int): Any {
        return listColors[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_gridview_color, null)

        val textView = view.findViewById<TextView>(R.id.lblColor)
        textView.text = listColors[position].first

        return view
    }
}