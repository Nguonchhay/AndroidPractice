package com.nguonchhay.attraction.fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.adapters.AttractionListAdapter
import com.nguonchhay.attraction.viewmodels.AttractionsViewModel
import kotlinx.coroutines.flow.collectLatest

class AttractionFragment(val context: Activity) : Fragment(R.layout.fragment_attraction) {

    lateinit var attractionViewModel: AttractionsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attractionViewModel = ViewModelProvider(this)[AttractionsViewModel::class.java]

        subscribeToObservables(view)

    }

    private fun subscribeToObservables(view: View) {
        lifecycleScope.launchWhenStarted {
            attractionViewModel.uiState.collectLatest {
                val adapter = AttractionListAdapter(context, it)
                val recycleView = view.findViewById<RecyclerView>(R.id.recycleAttraction)
                recycleView.adapter = adapter
                recycleView.layoutManager = LinearLayoutManager(context)
            }
        }
    }
}