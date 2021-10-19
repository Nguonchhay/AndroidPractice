package com.nguonchhay.attraction.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.nguonchhay.attraction.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            // Validate form
            val emailField: EditText = findViewById(R.id.editEmail)
            val emailValue = emailField.text.toString()

            val passwordField: EditText = findViewById(R.id.editPassword)
            val passwordValue = passwordField.text.toString()

            if (emailValue != "" && passwordValue != "") {
                // Call API to authenticate

                // Navigate to Main screen
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Show error
                Toast.makeText(this, "Fields are required!", Toast.LENGTH_LONG).show()
            }
        }

        val textRegisterField: TextView = findViewById(R.id.textRegister)
        textRegisterField.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}