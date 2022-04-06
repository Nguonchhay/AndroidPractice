package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityTextInputAndDialogBinding
import com.nguonchhay.androidcomponents.extensions.hideSoftKeyboard

class TextInputAndDialogActivity : AppCompatActivity() {

    lateinit var binding: ActivityTextInputAndDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextInputAndDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInputSubmit.setOnClickListener {
            val fullname: String = binding.textInputLayoutFullName.editText?.text.toString()
            binding.textInputLayoutFullName.isErrorEnabled = fullname == ""

            hideSoftKeyboard()
            if (fullname == "") {
                binding.textInputLayoutFullName.error = "Error"
                Snackbar.make(binding.textInputAndDialogLayout, "Check validation", Snackbar.LENGTH_SHORT).show()
            } else {
                binding.textInputLayoutFullName.error = null
            }
        }
    }
}