package com.nguonchhay.attraction.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguonchhay.attraction.adapters.AdminUserListAdapter
import com.nguonchhay.attraction.databinding.ActivityAdminUserBinding
import com.nguonchhay.attraction.rooms.AttractionAppDatabase
import com.nguonchhay.attraction.rooms.UserEntityInterface
import com.nguonchhay.attraction.rooms.entities.UserEntity
import com.nguonchhay.attraction.viewmodels.AdminUsersViewModel
import kotlinx.coroutines.flow.collectLatest

class AdminUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminUserBinding
    private lateinit var dbInstance: AttractionAppDatabase
    private lateinit var adminUserViewModel: AdminUsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbInstance = AttractionAppDatabase.getInstance(applicationContext)
        adminUserViewModel = ViewModelProvider(this)[AdminUsersViewModel::class.java]

        binding.rvAdminUsers.layoutManager = LinearLayoutManager(this)

        binding.btnAdminUserAdd.setOnClickListener {
            dbInstance.userDao.store(UserEntity(
                id = null,
                email = "user1@gmail.com",
                password = "1234567890",
                name="User 1"
            ))
            //refreshList()
        }

        subscribeToObservables()
    }

    private fun refreshList(users: List<com.nguonchhay.attraction.databases.entities.UserEntity>) {
        binding.rvAdminUsers.adapter = users?.let {
            AdminUserListAdapter(this@AdminUserActivity, it)
        }
    }

    private fun subscribeToObservables() {
        lifecycleScope.launchWhenStarted {
            adminUserViewModel.uiState.collectLatest {
                val userData = mutableListOf<com.nguonchhay.attraction.databases.entities.UserEntity>()
                it.forEach { data ->
                    val item = data as com.nguonchhay.attraction.databases.entities.UserEntity
                    userData.add(item)
                }
                refreshList(userData)
            }
        }
    }
}