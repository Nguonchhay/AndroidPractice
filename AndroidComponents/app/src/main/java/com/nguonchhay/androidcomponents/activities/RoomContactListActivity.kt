package com.nguonchhay.androidcomponents.activities

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityRoomContactListBinding

class RoomContactListActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomContactListBinding

    var contactActivity: RoomWithContactActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactActivity = RoomWithContactActivity()
        Thread {
            contactActivity!!.accessDatabase()
            val cursor: Cursor? = contactActivity!!.contactDao?.getContacts()

            runOnUiThread {
                val adapter = SimpleCursorAdapter(
                    this,
                    R.layout.item_contact,
                    cursor,
                    arrayOf(
                        cursor?.getColumnName(0),
                        cursor?.getColumnName(1),
                        cursor?.getColumnName(2)
                    ),
                    intArrayOf(
                        R.id.textId,
                        R.id.textName,
                        R.id.textPhone
                    ),
                    1
                )

                binding.lsvContacts.adapter = adapter
            }
        }.start()
    }
}