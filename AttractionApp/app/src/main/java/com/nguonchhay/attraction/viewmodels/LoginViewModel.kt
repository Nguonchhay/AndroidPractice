package com.nguonchhay.attraction.viewmodels

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.attraction.activities.MainActivity
import com.nguonchhay.attraction.databases.data.UserData
import com.nguonchhay.attraction.networks.ApiUserInterface
import com.nguonchhay.attraction.networks.ApiUtil
import com.nguonchhay.attraction.utils.SharedPreferenceUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState.Success())
    val uiState = _uiState.asStateFlow()

    fun login(emailValue: String, passwordValue: String) {
        _uiState.value = LoginState.Success(null, true)

        viewModelScope.launch {
            val userApi = ApiUtil.getInstance().create(ApiUserInterface::class.java)
            val userData = UserData(
                email = emailValue,
                password = passwordValue
            )
            val result = userApi.login(userData)

            if (result.isSuccessful) {
                _uiState.value = LoginState.Success(userData, false)
            } else {
                _uiState.value = LoginState.Success(null, false)
            }
        }
    }
}

sealed class LoginState {
    data class Success(val user: UserData? = null, val loading: Boolean = false)
}