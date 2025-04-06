package com.davidreyes.m7uf1_pokemon.ui.features.equipos
import com.davidreyes.m7uf1_pokemon.models.Equipo
import com.davidreyes.m7uf1_pokemon.models.Pokemon
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonUiState
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.toPokemonUiState


data class EquipoUiState(
    val id : String = "-1",
    val nombre: String = "",
    val pokemons: List<PokemonUiState> = emptyList()
)
fun Equipo.toEquipoUiState(): EquipoUiState =
    EquipoUiState(
        id = id,
        nombre = nombre,
        pokemons = pokemons.map { it.toPokemonUiState() }.toList()
    )

fun EquipoUiState.toEquipo(): Equipo =
    Equipo(
        id = id,
        nombre = nombre,
        pokemons = pokemons.map { Pokemon(id = it.id) }.toSet()
    )