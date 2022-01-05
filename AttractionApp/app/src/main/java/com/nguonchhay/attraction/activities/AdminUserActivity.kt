package com.nguonchhay.attraction.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databinding.ActivityAdminUserBinding
import com.nguonchhay.attraction.rooms.AttractionAppDatabase
import com.nguonchhay.attraction.rooms.entities.UserEntity

class AdminUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityAdminUserBinding
    lateinit var dbInstance: AttractionAppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbInstance = AttractionAppDatabase.getInstance(applicationContext)


        binding.rvAdminUsers.layoutManager = LinearLayoutManager(this)
        refreshList()

        binding.btnAdminUserAdd.setOnClickListener {
            dbInstance.userDao.store(UserEntity(
                id = null,
                email = "user1@gmail.com",
                password = "1234567890",
                name="User 1"
            ))
            refreshList()
        }
    }

    fun refreshList() {
        val users = dbInstance.userDao.list()
        binding.rvAdminUsers.adapter = users?.let {
            AdminUserListAdapter(this, it)
        }
    }
}

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
        val userData = listData[position]

        val nameView: TextView = holder.itemView.findViewById(R.id.adminUserName)
        nameView.text = userData.name

        val emailView: TextView = holder.itemView.findViewById(R.id.adminUserEmail)
        emailView.text = userData.email
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}