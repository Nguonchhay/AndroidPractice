package com.nguonchhay.androidcomponents.mvvm_minion.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.androidcomponents.databinding.ActivityCalculatorBinding
import com.nguonchhay.androidcomponents.mvvm_minion.viewmodel.CalculatorViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculatorBinding
    lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        stateObserver()

        binding.calBtnSum.setOnClickListener {
            val firstValue = binding.calEditFirst.text.toString().toDouble()
            val secondValue = binding.calEditSecond.text.toString().toDouble()
            calculatorViewModel.sum(firstValue, secondValue)
        }

        binding.calBtnSub.setOnClickListener {
            val firstValue = binding.calEditFirst.text.toString().toDouble()
            val secondValue = binding.calEditSecond.text.toString().toDouble()
            calculatorViewModel.sub(firstValue, secondValue)
        }

        binding.calBtnMul.setOnClickListener {
            val firstValue = binding.calEditFirst.text.toString().toDouble()
            val secondValue = binding.calEditSecond.text.toString().toDouble()
            calculatorViewModel.mul(firstValue, secondValue)
        }
    }

    private fun stateObserver() {
        lifecycleScope.launch {
            calculatorViewModel.uiState.collectLatest {
                binding.calEditResult.setText(it.result.toString())
                binding.calEditMethod.setText(it.method)
            }
        }
    }
}