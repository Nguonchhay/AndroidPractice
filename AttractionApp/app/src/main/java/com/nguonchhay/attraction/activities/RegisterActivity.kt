package com.nguonchhay.attraction.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.attraction.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = Calendar.getInstance()

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
    }
}