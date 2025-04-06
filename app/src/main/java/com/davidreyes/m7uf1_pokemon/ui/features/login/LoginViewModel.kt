package com.davidreyes.m7uf1_pokemon.ui.features.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidreyes.m7uf1_pokemon.data.services.authetication.AuthServiceException
import com.davidreyes.m7uf1_pokemon.data.services.authetication.AuthServiceImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthServiceImplementation
): ViewModel() {
    var loginState: LoginUiState by mutableStateOf(LoginUiState())
        private set

    private fun signIn(email: String, password: String, onSucess: () -> Unit) {
        viewModelScope.launch {
            try {
                authService.signIn(email, password)
                onSucess()
            } catch (e: AuthServiceException) {
                Log.d("AuthenticationViewModel", "Error: ${e.message}")
            }
        }
    }



    fun onLoginEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.OnCambiarContrasenya -> {
                loginState = loginState.copy(contrasenya = event.contrasenya)
            }
            is LoginEvent.OnCambiarEmail -> {
                loginState = loginState.copy(email = event.email)
            }
            is LoginEvent.OnIniciarSesion -> {
                if(
                    loginState.email.isNotEmpty() &&
                    loginState.contrasenya.isNotEmpty()
                ) {
                    signIn(
                        email = loginState.email,
                        password = loginState.contrasenya,
                        onSucess = event.onSucess
                    )
                }

            }
        }
    }
}