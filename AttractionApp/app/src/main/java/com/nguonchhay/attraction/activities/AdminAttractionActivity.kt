package com.nguonchhay.attraction.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguonchhay.attraction.adapters.AttractionAdminAdapter
import com.nguonchhay.attraction.databases.entities.AttractionEntity
import com.nguonchhay.attraction.databinding.ActivityAdminAttractionBinding
import com.nguonchhay.attraction.viewmodels.AttractionsViewModel
import kotlinx.coroutines.flow.collectLatest

class AdminAttractionActivity : AppCompatActivity() {

    lateinit var binding: ActivityAdminAttractionBinding
    lateinit var attractionViewModel: AttractionsViewModel
    lateinit var adapter: AttractionAdminAdapter
    var attractionData = ArrayList<AttractionEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminAttractionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AttractionAdminAdapter(this@AdminAttractionActivity, attractionData)
        val recycleView = binding.recycleAdminAttraction
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this@AdminAttractionActivity)

        attractionViewModel = ViewModelProvider(this)[AttractionsViewModel::class.java]
        subscribeToObservables()
    }

    private fun subscribeToObservables() {
        lifecycleScope.launchWhenStarted {
            attractionViewModel.uiState.collectLatest {
                attractionData.clear()
                attractionData.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}