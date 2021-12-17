package com.nguonchhay.attractioncompose.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.attractioncompose.entities.UserEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    fun login(user: UserEntity) {
        viewModelScope.launch {
            _uiState.value = LoginState(user = null, isLoading = true)
            Log.d("LoginViewModel", "Before API")
            // Call API

            Log.d("LoginViewModel", "Success API")
            _uiState.value = LoginState(user = UserEntity(
                id = "1",
                email = user.email,
                password = "",
                name = "Admin1"
            ), isLoading = false)

//            Log.d("LoginViewModel", "Failed API")
//            _uiState.value = LoginState(user = UserEntity(
//                email = user.email,
//                password = user.password
//            ), isLoading = false)
        }
    }
}

data class LoginState(
    val user: UserEntity? = null,
    val isLoading: Boolean = false,
    val err: String = ""
)
