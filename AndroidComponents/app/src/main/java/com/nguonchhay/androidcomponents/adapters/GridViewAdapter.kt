package com.nguonchhay.androidcomponents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.dataclasses.GridViewData

class GridViewAdapter(
    var items: List<GridViewData>,
    var context: Context
) : BaseAdapter() {

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): GridViewData {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_grid_view, parent, false)
        }

        val item = items.get(position)
        val imageView: ImageView = view!!.findViewById(R.id.imgGridViewImage)
        imageView.setImageResource(item.image)

        val titleView: TextView = view!!.findViewById(R.id.textGridViewTitle)
        titleView.text = item.title

        return view
    }
}