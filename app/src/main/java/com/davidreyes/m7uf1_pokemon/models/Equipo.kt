package com.davidreyes.m7uf1_pokemon.models

data class Equipo(
    val id : String = "-1",
    val nombre: String = "",
    val pokemons: Set<Int> = setOf()

)
