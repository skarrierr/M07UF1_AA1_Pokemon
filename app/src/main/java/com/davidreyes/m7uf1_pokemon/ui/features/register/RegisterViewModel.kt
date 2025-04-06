package com.davidreyes.m7uf1_pokemon.ui.features.register

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

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authService: AuthServiceImplementation
): ViewModel() {
    var registerState: RegisterUiState by mutableStateOf(RegisterUiState())
        private set

    fun register(email: String, password: String, onSucess: () -> Unit) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    authService.signUp(email, password)
                    authService.signIn(email, password)
                }
                onSucess()
            } catch (e: AuthServiceException) {
                Log.d("AuthenticationViewModel", "Error: ${e.stackTraceToString()}")
            }
        }
    }

    fun onRegisterEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.OnCambiarContrasenya -> {
                registerState = registerState.copy(contrasenya = event.contrasenya)
            }
            is RegisterEvent.OnCambiarEmail -> {
                registerState = registerState.copy(email = event.email)
            }
            is RegisterEvent.OnCambiarRepetirContrasenya -> {
                registerState = registerState.copy(repetirCotrasenya = event.contrasenya)
            }
            is RegisterEvent.OnRegistrarse -> {
                if(
                    registerState.email.isNotEmpty() &&
                    registerState.contrasenya.isNotEmpty() &&
                    registerState.contrasenya == registerState.repetirCotrasenya
                )
                register(
                    email = registerState.email,
                    password = registerState.contrasenya,
                    onSucess = event.onSucess
                )
            }
        }
    }
}