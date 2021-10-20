package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.adapters.ListViewAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityListviewBinding
import com.nguonchhay.androidcomponents.dataclasses.ListViewData

class ListviewActivity : AppCompatActivity() {

    lateinit var binding: ActivityListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuItems = listOf<String>(
            "home", "message", "setting"
        )
        val listData = mutableListOf<ListViewData>(
            ListViewData(R.drawable.ic_home, "Home"),
            ListViewData(R.drawable.ic_message, "Message"),
            ListViewData(R.drawable.icon_setting, "Setting")
        )
        val adapter = ListViewAdapter(this, listData)
        binding.listviewComponent.adapter = adapter
        binding.listviewComponent.isClickable = true
        binding.listviewComponent.setOnItemClickListener { parent, view, position, id ->
            when(menuItems[position]) {
                "home" -> {
                    Toast.makeText(this, "Go to home screen", Toast.LENGTH_SHORT).show()
                }
                "message" -> {
                    Toast.makeText(this, "Go to message screen", Toast.LENGTH_SHORT).show()
                }
                "setting" -> {
                    Toast.makeText(this, "Go to setting screen", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}