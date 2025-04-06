package com.davidreyes.m7uf1_pokemon.ui.features.equipos

import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonUiState

sealed interface EquipoEvent {
    data class OnClickPokemon(val pokemon:PokemonUiState): EquipoEvent
    data object OnActualizarEquipo: EquipoEvent
    data class OnSeleccionarEquipo(val equipo: EquipoUiState): EquipoEvent
    data object OnMostrarPokemons: EquipoEvent
    data object OnOcultarPokemons: EquipoEvent
}