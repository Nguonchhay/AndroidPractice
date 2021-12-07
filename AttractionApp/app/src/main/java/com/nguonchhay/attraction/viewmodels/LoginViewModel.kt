package com.nguonchhay.attraction.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguonchhay.attraction.databases.entities.UserEntity
import com.nguonchhay.attraction.networks.UserApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState.Success())
    val uiState = _uiState.asStateFlow()

    private val userApi = UserApi.create()

    fun login(emailValue: String, passwordValue: String) {
        _uiState.value = LoginState.Success(null, true)

        viewModelScope.launch {
//            val userApi = ApiUtil.getInstance().create(ApiUserInterface::class.java)
//            val userData = UserData(
//                email = emailValue,
//                password = passwordValue
//            )
//            val result = userApi.login(userData)
//
//            if (result.isSuccessful) {
//                _uiState.value = LoginState.Success(userData, false)
//            } else {
//                _uiState.value = LoginState.Success(null, false)
//            }
            val userData = UserEntity(
                email = emailValue,
                password = passwordValue
            )
            val result = userApi.login(userData)
            if (result.id == null)  {
                _uiState.value = LoginState.Success(null, false)
            } else {
                _uiState.value = LoginState.Success(userData, false)
            }
        }
    }
}

sealed class LoginState {
    data class Success(val user: UserEntity? = null, val loading: Boolean = false)
}