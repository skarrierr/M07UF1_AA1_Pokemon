package com.davidreyes.m7uf1_pokemon.ui.features.register

import com.davidreyes.m7uf1_pokemon.ui.features.login.LoginEvent

sealed interface RegisterEvent {
    data class OnCambiarEmail(val email: String): RegisterEvent
    data class OnCambiarContrasenya(val contrasenya: String): RegisterEvent
    data class OnCambiarRepetirContrasenya(val contrasenya: String): RegisterEvent
    data class OnRegistrarse(val onSucess: () -> Unit): RegisterEvent
}