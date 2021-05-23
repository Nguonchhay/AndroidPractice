package com.nguonchhay.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast: Button = findViewById<Button>(R.id.btnShowToast)
        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Clicked on button")

            Toast.makeText(this, "Clicked me to toast", Toast.LENGTH_LONG).show()
        }

        val message: String = findViewById<EditText>(R.id.editMessage).text.toString()

        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", message)

            startActivity(intent)
        }

        val btnShareMessage: Button = findViewById(R.id.btnShareMessage)
        btnShareMessage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share Message To:"))
        }

        val btnRecycleView: Button = findViewById(R.id.btnRecycleView)
        btnRecycleView.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}