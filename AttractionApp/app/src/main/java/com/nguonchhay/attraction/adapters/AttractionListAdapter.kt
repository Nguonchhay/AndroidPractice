package com.nguonchhay.attraction.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.activities.AttractionActivity
import com.nguonchhay.attraction.databases.entities.AttractionEntity

class AttractionListAdapter(
    private val context: Activity,
    private val listData: List<AttractionEntity>
) : RecyclerView.Adapter<AttractionListAdapter.AttractionViewHolder>() {

    inner class AttractionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttractionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_attraction, parent, false)
        return AttractionViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttractionViewHolder, position: Int) {
        val attraction = listData[position]

        val imageView: ImageView = holder.itemView.findViewById(R.id.attractImage)
        Glide.with(context).load(attraction.image).override(100, 100).into(imageView)

        val titleView: TextView = holder.itemView.findViewById(R.id.attractTitle)
        titleView.text = attraction.title

        val descriptionView: TextView = holder.itemView.findViewById(R.id.attractionDesc)
        descriptionView.text = attraction.description

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AttractionActivity::class.java)
            intent.putExtra("ATTRACTION_ID", attraction.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}