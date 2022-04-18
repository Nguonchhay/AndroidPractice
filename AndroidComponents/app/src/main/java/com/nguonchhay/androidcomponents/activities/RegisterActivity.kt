package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val items = listOf("---", "Male", "Female", "Others")
        val items = resources.getStringArray(R.array.genders)
        val adapter = ArrayAdapter(this, R.layout.list_gender_items, items)
        (binding.genderWrapper.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        binding.btnRegister.setOnClickListener {

            if (binding.emailWrapper.editText?.text.toString() == "") {
                binding.emailWrapper.error = "Email is  require!"
            } else {
                binding.emailWrapper.error = null
            }
        }
    }
}