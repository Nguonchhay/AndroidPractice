package com.nguonchhay.androidcomponents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.dataclasses.MinionCardData

class RecyclerCardViewAdapter(
    var minionData: List<MinionCardData>
) : RecyclerView.Adapter<RecyclerCardViewAdapter.RecyclerCardViewHolder>() {

    inner class RecyclerCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCardViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_cardview, parent, false)
        return RecyclerCardViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: RecyclerCardViewHolder, position: Int) {
        val minionItem = minionData.get(position)
        val viewTitle = holder.itemView.findViewById<TextView>(R.id.textCardTitle)
        viewTitle.text = minionItem.title

        val viewDescription = holder.itemView.findViewById<TextView>(R.id.textCardDescription)
        viewDescription.text = minionItem.description

        val viewImage = holder.itemView.findViewById<ImageView>(R.id.imgCardImage)
        viewImage.setImageResource(minionItem.image)
    }

    override fun getItemCount(): Int {
        return minionData.size
    }
}