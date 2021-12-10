package com.nguonchhay.attraction.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.activities.AttractionEditActivity
import com.nguonchhay.attraction.databases.entities.AttractionEntity

class AttractionAdminAdapter(
    private val context: Activity,
    private val listData: ArrayList<AttractionEntity>
) : RecyclerView.Adapter<AttractionAdminAdapter.AttractionViewHolder>() {

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

        holder.itemView.setOnLongClickListener(View.OnLongClickListener {
            markSelectItem(position,  holder.itemView)
        })
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    private fun markSelectItem(position: Int,  v: View): Boolean {
        PopupMenu(context, v).apply {
            setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    return when (item?.itemId) {
                        R.id.menuEdit -> {
                            context.startActivity(Intent(context, AttractionEditActivity::class.java))
                            true
                        }
                        R.id.menuDelete -> {
                            listData.removeAt(position)
                            notifyItemRemoved(position)
                            true
                        }
                        else -> {
                            Toast.makeText(context, "Else", Toast.LENGTH_SHORT).show()
                            false
                        }
                    }
                }
            })
            inflate(R.menu.menu_edit_delete_options)
            show()
        }

        return true
    }
}