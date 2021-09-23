package com.nguonchhay.androidcomponents.activities

import android.app.DatePickerDialog
import android.content.RestrictionEntry.TYPE_NULL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityViewComponentBinding
import com.nguonchhay.androidcomponents.extensions.disableClick
import com.nguonchhay.androidcomponents.extensions.hideSoftKeyboard
import java.util.*

class ViewComponentActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewComponentActivity.setOnClickListener {
            hideSoftKeyboard()
        }

        binding.btnFloatSend.setOnClickListener {
            var allText: String? = ""

            allText += binding.editPlainText.text.toString()
            allText += binding.editPassword.text.toString()
            allText += binding.editEmail.text.toString()
            allText += binding.editPhone.text.toString()
            allText += binding.editDate.text.toString()
            allText += binding.editNumberSigned.text.toString()
            allText += binding.spinDay.selectedItem.toString()

            Toast.makeText(this, allText, Toast.LENGTH_LONG).show()
        }

        // Calendar
        val calendar = Calendar.getInstance()
        val datePickerDialogListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            binding.editDate.setText("$dayOfMonth-$month-$year")
        }

        // Disable EditDate
        binding.editDate.disableClick()

        val datePickerDialog = DatePickerDialog(
            this,
            datePickerDialogListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        binding.editDate.setOnClickListener {
            datePickerDialog.show()
        }

        binding.imgDatePicker.setOnClickListener {
            datePickerDialog.show()
        }

        binding.spinDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@ViewComponentActivity, adapterView?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Nothing to do
            }

        }

        val customList = listOf<String>("Mon", "Tue", "Wed")
        val spinnerAdapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)

        binding.btnSpinReAssign.setOnClickListener {
            binding.spinDay.adapter = spinnerAdapter
        }
    }
}