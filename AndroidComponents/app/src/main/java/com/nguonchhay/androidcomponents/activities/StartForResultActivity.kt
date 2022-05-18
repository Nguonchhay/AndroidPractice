package com.nguonchhay.androidcomponents.activities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.nguonchhay.androidcomponents.contracts.ResultFromActivityContract
import com.nguonchhay.androidcomponents.databinding.ActivityStartForResultBinding
import com.theartofdev.edmodo.cropper.CropImage

private var REQUEST_CODE_PERMISSION = 123

class StartForResultActivity : AppCompatActivity() {

    private val LOG_TAG = "AC LOG: "

    lateinit var binding: ActivityStartForResultBinding

    private val cropActivityResultContract = object: ActivityResultContract<Any?, Uri>() {
        override fun createIntent(context: Context, input: Any?): Intent {
            return CropImage.activity()
                    .setAspectRatio(16, 9)
                    .getIntent(this@StartForResultActivity)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Uri {
            return CropImage.getActivityResult(intent)?.uri!!
        }
    }

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
                Log.d(LOG_TAG, "binding.btnPermission.setOnClickListener => GRANT")
            } else {
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA), REQUEST_CODE_PERMISSION)
                Log.d(LOG_TAG, "requestPermissions")
            }
        }

        // Gallery
        val getImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                Log.d(LOG_TAG, "ActivityResultCallback")
                binding.imgSelectedItem.setImageURI(it)
            }
        )

        binding.btnStartGallery.setOnClickListener {
            getImage.launch("image/*")
        }
        // End Gallery

        // Camera
//        val takePhoto = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult(),
//            ActivityResultCallback<ActivityResult>() { activityResult ->
//                if (activityResult.resultCode == RESULT_OK) {
//                    val bitmap = activityResult.data?.extras?.get("data") as Bitmap
//                    binding.imgPhoto.setImageBitmap(bitmap)
//                }
//            }
//        )
        val takePhoto = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val bitmap = it?.data?.extras?.get("data") as Bitmap
            binding.imgPhoto.setImageBitmap(bitmap)
        }

        binding.btnTakePicture.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                takePhoto.launch(intent)
            }
        }

        // End Camera

        // Start another activity for result
        val resultLauncher = registerForActivityResult(
            ResultFromActivityContract(),
            ActivityResultCallback {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        )

        binding.btnStartActivityForResult.setOnClickListener {
            resultLauncher.launch(null)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSION) {
            Log.d(LOG_TAG, grantResults.toString())
        }
    }
}