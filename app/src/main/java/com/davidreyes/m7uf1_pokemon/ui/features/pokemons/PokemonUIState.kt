package com.davidreyes.m7uf1_pokemon.ui.features.pokemons

import android.net.Uri
import com.davidreyes.m7uf1_pokemon.models.Pokemon

data class PokemonUiState(
    val id: String = "-1",
    val nombre: String = "",
    val nivel: Int = 1,
    val vida: Int = 0,
    val ataque: Int = 0,
    val defensa: Int = 0,
    val velocidad: Int = 0,
    val tipo: TipoUiState = TipoUiState(),
    val imagen: Uri = Uri.EMPTY
)

fun Pokemon.toPokemonUiState(): PokemonUiState =
    PokemonUiState(
        id = id,
        nombre = nombre,
        nivel = nivel,
        vida = vida,
        ataque = ataque,
        defensa = defensa,
        velocidad = velocidad,
        tipo = tipo.toTipoUiState(),
        imagen = imagen
    )