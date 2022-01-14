package com.nguonchhay.attraction.activities

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.nguonchhay.attraction.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = Calendar.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()

        val birthDateDialogListener = DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
            binding.editBirthDate.setText("$dayOfMonth-$month-$year");
        }

        val birthDateDialog = DatePickerDialog(
            this,
            birthDateDialogListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
        )

        binding.imgBirthDate.setOnClickListener {
            // Call DatePicker
            birthDateDialog.show()
        }

        binding.btnRegister.setOnClickListener {
            validateData()
        }
    }

    fun validateData() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                // Save more user data
                val name = binding.editFullName.text.toString()
//                val birthDate = binding.editBirthDate.text.toString()
//
//                val selectedRadioInt = binding.radGroupGener.checkedRadioButtonId
//                val radGender: RadioButton = findViewById(selectedRadioInt)
//                val gender = radGender.text.toString()

                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .build()
                firebaseAuth.currentUser!!.updateProfile(profileUpdates)

                Toast.makeText(this, "Registered as $email", Toast.LENGTH_LONG).show()
                // Navigate to Main screen
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this@RegisterActivity, "Sign up failed due to ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}