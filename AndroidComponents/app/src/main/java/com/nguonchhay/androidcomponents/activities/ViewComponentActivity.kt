package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.databinding.ActivityViewComponentBinding

class ViewComponentActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

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