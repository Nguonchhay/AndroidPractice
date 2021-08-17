package com.nguonchhay.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nguonchhay.firstapp.databinding.ActivityContactBinding
import com.nguonchhay.firstapp.extensions.hideSoftKeyboard

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityContact.setOnClickListener {
            hideSoftKeyboard()
        }

        binding.btnSend.setOnClickListener {
            val intent = Intent(this, ThankYouActivity::class.java)
            val email = binding.editEmail.text.toString()
            val fullName = binding.editFulName.text.toString()
            val subject = binding.editSubject.text.toString()
            val message = binding.editMessage.text.toString()
            if (email.isNotEmpty() && fullName.isNotEmpty() && subject.isNotEmpty()) {
                intent.putExtra("email", email)
                intent.putExtra("fullName", fullName)
                intent.putExtra("subject", subject)
                intent.putExtra("message", message)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Missing required fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}