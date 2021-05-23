package com.nguonchhay.msgshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.msgshareapp.adapters.HobbyAdapter
import com.nguonchhay.msgshareapp.models.HobbiesSupplier

class HobbiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        val rcvHobby: RecyclerView = findViewById(R.id.rcvHobbies)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rcvHobby.layoutManager = layoutManager

        val adapter = HobbyAdapter(this, HobbiesSupplier.hobbies)
        rcvHobby.adapter = adapter
    }
}