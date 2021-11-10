package com.nguonchhay.attraction.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.attraction.R
import com.nguonchhay.attraction.adapters.AttractionListAdapter
import com.nguonchhay.attraction.databases.data.AttractionItem
import com.nguonchhay.attraction.networks.ApiAttractionInterface
import com.nguonchhay.attraction.networks.ApiUtil
import kotlinx.coroutines.launch

class AttractionFragment(val context: Activity) : Fragment(R.layout.fragment_attraction) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val attractionApi = ApiUtil.getInstance().create(ApiAttractionInterface::class.java)
        lifecycleScope.launch {
            try {
                val result = attractionApi.list()
                val attractions = arrayListOf<AttractionItem>()
                if (result.isSuccessful)  {
                    result.body()?.iterator()?.forEach {
                        attractions.add(it)
                    }

                    val adapter = AttractionListAdapter(context, attractions)
                    val recycleView = view.findViewById<RecyclerView>(R.id.recycleAttraction)
                    recycleView.adapter = adapter
                    recycleView.layoutManager = LinearLayoutManager(context)
                } else {
                    Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.d("attractions", "ERROR: ${e.toString()}")
            }
        }
    }

}