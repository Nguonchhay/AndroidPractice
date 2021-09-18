package com.nguonchhay.androidcomponents.activities

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.nguonchhay.androidcomponents.databinding.ActivityStartForResultBinding

private var REQUEST_CODE_PERMISSION = 123

class StartForResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityStartForResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from MainActivity
        val bundle: Bundle? = intent.extras
        binding.lblFromMain.text = "From MainActivity: " + bundle!!.getString("msg")

        binding.btnPermission.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                binding.lblPermission.text = "Permission is GRANT!"
                Log.d("OHLALA => ", "binding.btnPermission.setOnClickListener => GRANT")
            } else {
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA), REQUEST_CODE_PERMISSION)
                Log.d("OHLALA => ", "requestPermissions")
            }
        }

        val getImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                Log.d("OHLALA => ", "ActivityResultCallback")
                binding.imgSelectedItem.setImageURI(it)
            }
        )

        binding.btnStartGallery.setOnClickListener {
            getImage.launch("image/*")
        }

        binding.btnStartActivityForResult.setOnClickListener {
            val intent = Intent(this, ResultFromStartActivity::class.java)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSION) {
            Log.d("OHLALA => ", grantResults.toString())
        }
    }
}