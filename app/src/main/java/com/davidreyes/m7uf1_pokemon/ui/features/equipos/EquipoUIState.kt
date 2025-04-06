package com.davidreyes.m7uf1_pokemon.ui.features.equipos
import com.davidreyes.m7uf1_pokemon.models.Equipo


data class EquipoUiState(
    val id : String = "-1",
    val nombre: String = "",
    val pokemons: List<Int> = emptyList()
)
fun Equipo.toEquipoUiState(): EquipoUiState =
    EquipoUiState(
        id = id,
        nombre = nombre,
        pokemons = pokemons.toList()
    )