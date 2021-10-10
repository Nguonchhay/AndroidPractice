package com.nguonchhay.androidcomponents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.androidcomponents.R

class ViewPager2Adapter(val images: List<Int>): RecyclerView.Adapter<ViewPager2Adapter.ViewPagerHolder>() {

    inner class ViewPagerHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager2, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val curImage = images[position]
        val imageView = holder.itemView.findViewById<ImageView>(R.id.imgView)
        imageView.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}