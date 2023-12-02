package com.example.TechTusQuiz.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.TechTusQuiz.Authentication.AuthenticationRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthenticationRepo = AuthenticationRepo()
) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError = _loginError.asStateFlow()

    private val _isSuccessLogin = MutableStateFlow(false)
    val isSuccessLogin = _isSuccessLogin.asStateFlow()

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun login() = viewModelScope.launch {
        if (username.value.isBlank() || password.value.isBlank()) {
            _loginError.value = "Username and password can't be empty"
            return@launch
        }

        _isLoading.value = true
        val result = repository.login(username.value, password.value)
        _isLoading.value = false

        if (result.isSuccess) {
            _isSuccessLogin.value = true
            _loginError.value = null
            Log.d("LoginViewModel", "Login successful")
        } else {
            _loginError.value = result.exceptionOrNull()?.message
        }
    }
}