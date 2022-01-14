package com.nguonchhay.attraction.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
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
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Check auth user instead of local access_token
        firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.currentUser
        if (user != null) {
            // Navigate to Main screen
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

//        // Check access_token
//        val preference = SharedPreferenceUtil(this)
//        if (preference.getItem("ACCESS_TOKEN") != "") {
//            // Navigate to Main screen
//            val intent = Intent(this@LoginActivity, MainActivity::class.java)
//            startActivity(intent)
//        }

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

//            if (emailValue != "" && passwordValue != "") {
//                LoadingDialog.displayLoadingWithText(this, "Loading")
//
//                loginViewModel.login(emailValue, passwordValue)
//            } else {
//                // Show error
//                Toast.makeText(this, "Fields are required!", Toast.LENGTH_LONG).show()
//            }
            validateData(emailValue, passwordValue)
        }

        val textRegisterField: TextView = findViewById(R.id.textRegister)
        textRegisterField.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun validateData(emailValue: String, passwordValue: String) {
        if (!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            Toast.makeText(this, "Invalid Email format", Toast.LENGTH_LONG).show()
        } else if (TextUtils.isEmpty(passwordValue)) {
            Toast.makeText(this, "Please input password", Toast.LENGTH_LONG).show()
        } else {
            firebaseLogin(emailValue, passwordValue)
        }
    }

    fun firebaseLogin(emailValue: String, passwordValue: String) {
        firebaseAuth.signInWithEmailAndPassword(emailValue, passwordValue)
            .addOnSuccessListener {
                Toast.makeText(this, "Logged in as $emailValue", Toast.LENGTH_LONG).show()
                // Navigate to Main screen
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this@LoginActivity, "login failed due to ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}