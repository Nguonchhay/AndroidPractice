package com.nguonchhay.androidcomponents.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nguonchhay.androidcomponents.databinding.ActivityRoomWithContactBinding
import com.nguonchhay.androidcomponents.dataclasses.AppDatabase
import com.nguonchhay.androidcomponents.dataclasses.dao.ContactDao
import com.nguonchhay.androidcomponents.dataclasses.entities.Contact

class RoomWithContactActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomWithContactBinding

    var appDatabase: AppDatabase? = null
    var contactDao: ContactDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomWithContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val contact = Contact(null, binding.editName.text.toString(), binding.editPhone.text.toString())
            // Initialize database instance in Thread
            Thread {
                accessDatabase()

                contactDao?.storeContact(contact)
                startActivity(Intent(this, RoomContactListActivity::class.java))
            }.start()
        }
    }

    fun accessDatabase() {
        appDatabase = AppDatabase.getAppDatabase(this)
        contactDao = appDatabase?.contactDAO()
    }
}