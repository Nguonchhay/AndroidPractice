package com.nguonchhay.attraction.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.databases.data.UserData
import com.nguonchhay.attraction.utils.LoadingDialog
import com.nguonchhay.attraction.networks.ApiUserInterface
import com.nguonchhay.attraction.networks.ApiUtil
import com.nguonchhay.attraction.utils.SharedPreferenceUtil
import com.nguonchhay.attraction.viewmodels.LoginViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Check access_token
        val preference = SharedPreferenceUtil(this)
        if (preference.getItem("ACCESS_TOKEN") != "") {
            // Navigate to Main screen
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        lifecycleScope.launchWhenStarted {
            loginViewModel.uiState.collectLatest {
                if (!it.loading) {
                    LoadingDialog.hideLoading()
                }

                if (it.user != null) {
                    val preference = SharedPreferenceUtil(this@LoginActivity)
                    preference.storeItem("ACCESS_TOKEN", "Pass your access_token key here")

                    // Navigate to Main screen
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            // Validate form
            val emailField: EditText = findViewById(R.id.editEmail)
            val emailValue = emailField.text.toString()

            val passwordField: EditText = findViewById(R.id.editPassword)
            val passwordValue = passwordField.text.toString()

            if (emailValue != "" && passwordValue != "") {
                LoadingDialog.displayLoadingWithText(this, "Loading")

                loginViewModel.login(emailValue, passwordValue)
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