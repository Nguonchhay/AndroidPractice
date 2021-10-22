package com.nguonchhay.attraction.databases.di

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.attraction.databases.data.AttractionItem
import com.nguonchhay.attraction.databases.interfaces.AttractionApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: AttractionApi
) : ViewModel() {

    private val _state = mutableStateOf(AttractionState())
    private val state: State<AttractionState> = _state

    init {
        getAttractions()
    }

    fun getAttractions() {
        viewModelScope.launch {
            try {
                _state.value = state.value.copy(isLoading = true)
                _state.value = state.value.copy(
                    attractions = api.list(),
                    isLoading = false
                )

            } catch (e: Exception) {
                Log.e("MainViewModel", "getAttractions", e)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    data class AttractionState(
        val attractions: MutableList<AttractionItem>? = null,
        val isLoading: Boolean = false
    )

}