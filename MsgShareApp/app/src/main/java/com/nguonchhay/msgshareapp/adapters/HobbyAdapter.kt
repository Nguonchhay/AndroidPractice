package com.nguonchhay.msgshareapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.msgshareapp.R
import com.nguonchhay.msgshareapp.models.Hobby

class HobbyAdapter (val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.hobbies_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)

    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)

        fun setData(hobby: Hobby?, pos: Int) {
            txtTitle.text = hobby!!.title
        }
    }
}