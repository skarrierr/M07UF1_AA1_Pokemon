package com.davidreyes.m7uf1_pokemon.ui.features.login

sealed interface LoginEvent {
    data class OnCambiarEmail(val email: String): LoginEvent
    data class OnCambiarContrasenya(val contrasenya: String): LoginEvent
    data class OnIniciarSesion(val onSucess: () -> Unit): LoginEvent
}