package com.nguonchhay.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.nguonchhay.msgshareapp.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val txtMessage: TextView = findViewById<TextView>(R.id.txtMessage);
        txtMessage.text = bundle!!.getString("message")
    }
}