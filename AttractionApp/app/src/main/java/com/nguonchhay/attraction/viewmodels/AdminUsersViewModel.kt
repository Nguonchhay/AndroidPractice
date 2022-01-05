package com.nguonchhay.attraction.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.attraction.networks.UserApi
import com.nguonchhay.attraction.rooms.UserEntityInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AdminUsersViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(listOf<UserEntityInterface>())
    val uiState: StateFlow<List<UserEntityInterface>> = _uiState.asStateFlow()

    private val userApi = UserApi.create()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            val result = userApi.list()
            _uiState.value = result
        }
    }
}