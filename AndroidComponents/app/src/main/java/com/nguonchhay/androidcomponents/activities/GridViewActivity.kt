package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.adapters.GridViewAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityGridViewBinding
import com.nguonchhay.androidcomponents.dataclasses.GridViewData

class GridViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityGridViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gridViewData = mutableListOf<GridViewData>(
            GridViewData(R.drawable.minion1, "Minion 1"),
            GridViewData(R.drawable.minion2, "Minion 2"),
            GridViewData(R.drawable.minion3, "Minion 3"),
            GridViewData(R.drawable.minion4, "Minion 4"),
            GridViewData(R.drawable.minion5, "Minion 5")
        )

        val gridViewAdapter = GridViewAdapter(gridViewData, this)
        binding.gridView.adapter = gridViewAdapter

        binding.imgGridViewBack.setOnClickListener {
            finish()
        }

    }
}