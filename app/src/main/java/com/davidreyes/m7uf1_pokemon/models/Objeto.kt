package com.davidreyes.m7uf1_pokemon.models

import android.net.Uri

data class Objeto(
    val id : String = "-1",
    val nombre: String = "",
    val precio: Int = 0,
    val imagen: Uri = Uri.EMPTY
)