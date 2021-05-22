package com.nguonchhay.msgshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast = findViewById<Button>(R.id.btnShowToast);
        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Clicked on button")

            Toast.makeText(this, "Clicked me to toast", Toast.LENGTH_LONG).show()
        }
    }
}