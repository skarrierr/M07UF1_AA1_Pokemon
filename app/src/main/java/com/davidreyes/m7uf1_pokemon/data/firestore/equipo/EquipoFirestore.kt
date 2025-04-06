package com.davidreyes.m7uf1_pokemon.data.firestore.equipo

data class EquipoFirestore(
    val id : String = "-1",
    val nombre: String = "",
    val pokemons: List<Int> = emptyList()
)
