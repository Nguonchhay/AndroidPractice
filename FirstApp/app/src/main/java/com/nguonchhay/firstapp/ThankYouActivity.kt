package com.nguonchhay.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.firstapp.databinding.ActivityThankYouBinding

class ThankYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThankYouBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myIntent: Intent = intent
        binding.textEmail.text = myIntent.getStringExtra("email").toString()
        binding.textFullName.text = myIntent.getStringExtra("fullName").toString()
        binding.textSubject.text = myIntent.getStringExtra("subject").toString()
        binding.textMessage.text = myIntent.getStringExtra("message").toString()
    }
}