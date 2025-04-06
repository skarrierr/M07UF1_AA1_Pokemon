package com.davidreyes.m7uf1_pokemon.ui.features.loading

sealed interface LoadingEvent {
    data class OnManageSession(
        val onNavigateToPokemons: () -> Unit,
        val onNavigateToLogin: () -> Unit
    ): LoadingEvent
}