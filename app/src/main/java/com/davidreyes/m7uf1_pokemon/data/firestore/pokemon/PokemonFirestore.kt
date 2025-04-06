package com.davidreyes.m7uf1_pokemon.data.firestore.pokemon

data class PokemonFirestore(
    val id: String = "-1",
    val nombre: String = "",
    val nivel: Int = 1,
    val vida: Int = 0,
    val ataque: Int = 0,
    val defensa: Int = 0,
    val velocidad: Int = 0,
    val tipo: String = "-1",
    val imagen: String = ""
)
