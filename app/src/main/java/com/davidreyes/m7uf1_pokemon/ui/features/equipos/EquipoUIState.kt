package com.davidreyes.m7uf1_pokemon.ui.features.equipos

import android.net.Uri
import com.davidreyes.m7uf1_pokemon.models.Tipo


data class EquipoUiState(
    val id : String = "-1",
    val nombre: String = "",
    val pokemons: List<Int> = emptyList()
)
fun Tipo.toEquipoUiState(): EquipoUiState =
    EquipoUiState(
        id = id,
        nombre = nombre,
       // pokemons = pokemons
    )