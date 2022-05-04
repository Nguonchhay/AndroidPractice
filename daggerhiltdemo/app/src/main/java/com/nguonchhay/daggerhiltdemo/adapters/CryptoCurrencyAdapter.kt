package com.nguonchhay.daggerhiltdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nguonchhay.daggerhiltdemo.R
import com.nguonchhay.daggerhiltdemo.data_class.CryptoCurrency

class CryptoCurrencyAdapter(val listData: List<CryptoCurrency>) : RecyclerView.Adapter<CryptoCurrencyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cryptocurrency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        val imageView = holder.itemView.findViewById<ImageView>(R.id.cryptocurrencyImage)
        Glide.with(holder.itemView.context)
            .load(item.image)
            .into(imageView)

        val titleView = holder.itemView.findViewById<TextView>(R.id.cryptocurrencyTitle)
        titleView.text = item.name
    }

    override fun getItemCount(): Int = listData.size
}