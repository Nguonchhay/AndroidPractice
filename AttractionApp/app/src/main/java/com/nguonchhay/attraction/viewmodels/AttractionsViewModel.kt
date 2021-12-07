package com.nguonchhay.attraction.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.attraction.databases.data.AttractionItem
import com.nguonchhay.attraction.databases.entities.AttractionEntity
import com.nguonchhay.attraction.networks.ApiAttractionInterface
import com.nguonchhay.attraction.networks.ApiUtil
import com.nguonchhay.attraction.networks.AttractionApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AttractionsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(listOf<AttractionEntity>())
    val uiState: StateFlow<List<AttractionEntity>> = _uiState.asStateFlow()

    private val attractionApi = AttractionApi.create()

    init {
        loadAttractions()
    }

    private fun loadAttractions() {
//        val attractionApi = ApiUtil.getInstance().create(ApiAttractionInterface::class.java)
//        viewModelScope.launch {
//            val result = attractionApi.list()
//            val attractions = mutableListOf<AttractionItem>()
//            if (result.isSuccessful)  {
//                result.body()?.iterator()?.forEach {
//                    attractions.add(it)
//                }
//
//                _uiState.value = attractions
//            } else {
//                Log.d("attractions", "Something went wrong!")
//            }
//        }
        viewModelScope.launch {
            val attractionData = attractionApi.list()
            _uiState.value = attractionData
        }
    }
}