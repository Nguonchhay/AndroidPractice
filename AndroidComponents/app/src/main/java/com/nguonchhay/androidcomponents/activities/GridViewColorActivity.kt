package com.nguonchhay.androidcomponents.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.nguonchhay.androidcomponents.adapters.GridViewColorAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityGridViewColorBinding

class GridViewColorActivity : AppCompatActivity() {
    lateinit var binding: ActivityGridViewColorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colors = listOf<Pair<String, Int>>(
            Pair("INDIANRED", Color.parseColor("#CD5C5C")),
            Pair("LIGHTCORAL", Color.parseColor("#F08080")),
            Pair("SALMON", Color.parseColor("#FA8072")),
            Pair("DARKSALMON", Color.parseColor("#E9967A")),
            Pair("LIGHTSALMON", Color.parseColor("#FFA07A")),
            Pair("CRIMSON", Color.parseColor("#DC143C")),
            Pair("RED", Color.parseColor("#FF0000")),
            Pair("FIREBRICK", Color.parseColor("#B22222")),
            Pair("DARKRED", Color.parseColor("#8B0000")),

            Pair("PINK", Color.parseColor("#FFC0CB")),
            Pair("LIGHTPINK", Color.parseColor("#FFB6C1")),
            Pair("HOTPINK", Color.parseColor("#FF69B4")),
            Pair("DEEPPINK", Color.parseColor("#FF1493")),
            Pair("MEDIUMVIOLETRED", Color.parseColor("#C71585")),
            Pair("PALEVIOLETRED", Color.parseColor("#DB7093"))
        )

        val adapter = GridViewColorAdapter(colors)
        binding.gvColors.adapter = adapter
        binding.gvColors.numColumns = 2
        binding.gvColors.horizontalSpacing = 15
        binding.gvColors.verticalSpacing = 15
        binding.gvColors.stretchMode = GridView.STRETCH_COLUMN_WIDTH
    }
}