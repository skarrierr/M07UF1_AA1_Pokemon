package com.davidreyes.m7uf1_pokemon.ui.features.objetos

import android.net.Uri
import com.davidreyes.m7uf1_pokemon.models.Objeto


data class ObjetoUiState(
    val id : String = "-1",
    val nombre: String = "",
    val precio: Int = 0,
    val imagen: Uri = Uri.EMPTY
)
fun Objeto.toObjetoUiState(): ObjetoUiState =
    ObjetoUiState(
        id = id,
        nombre = nombre,
        precio = precio,
        imagen = imagen
    )