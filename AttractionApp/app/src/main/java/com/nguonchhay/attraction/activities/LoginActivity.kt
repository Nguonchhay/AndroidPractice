package com.nguonchhay.attraction.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databases.data.UserData
import com.nguonchhay.attraction.dialogs.LoadingDialog
import com.nguonchhay.attraction.networks.ApiUserInterface
import com.nguonchhay.attraction.networks.ApiUtil
import kotlinx.coroutines.launch

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
                LoadingDialog.displayLoadingWithText(this, "Loading")

                // Call API to authenticate
                lifecycleScope.launch {
                    val userApi = ApiUtil.getInstance().create(ApiUserInterface::class.java)
                    val result = userApi.login(UserData(
                        email = emailValue,
                        password = passwordValue
                    ))

                    if (result.isSuccessful) {
                        // Navigate to Main screen
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                    }

                    LoadingDialog.hideLoading()
                }


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