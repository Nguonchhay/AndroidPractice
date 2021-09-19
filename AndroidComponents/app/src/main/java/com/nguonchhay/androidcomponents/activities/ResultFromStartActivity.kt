package com.nguonchhay.androidcomponents.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.androidcomponents.contracts.ResultFromActivityContract
import com.nguonchhay.androidcomponents.databinding.ActivityResultFromStartBinding

class ResultFromStartActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultFromStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultFromStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendMessage.setOnClickListener {
            val result = Intent().putExtra(ResultFromActivityContract.MESSAGE, "Message from ResultFromStart")
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}