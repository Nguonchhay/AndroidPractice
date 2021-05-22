package com.nguonchhay.msgshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val txtMessage: TextView = findViewById<TextView>(R.id.txtMessage);
        txtMessage.text = bundle!!.getString("message")
    }
}