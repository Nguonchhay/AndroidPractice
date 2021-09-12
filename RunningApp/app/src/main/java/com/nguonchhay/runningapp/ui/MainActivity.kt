package com.nguonchhay.runningapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.runningapp.databases.DAO.RunDAO
import com.nguonchhay.runningapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

//    @Inject
//    lateinit var runDao: RunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}