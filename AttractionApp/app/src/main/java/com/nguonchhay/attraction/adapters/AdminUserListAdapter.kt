package com.nguonchhay.attraction.adapters

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databases.entities.UserEntity

class AdminUserListAdapter(
    private val context: Activity,
    private val listData: List<UserEntity>
) : RecyclerView.Adapter<AdminUserListAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_admin_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userData: UserEntity = listData[position]
        Log.d("onBindViewHolder" ,"${userData.name} - ${userData.email}")

        val nameView: TextView = holder.itemView.findViewById(R.id.adminUserName)
        nameView.text = userData.name

        val emailView: TextView = holder.itemView.findViewById(R.id.adminUserEmail)
        emailView.text = userData.email
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}