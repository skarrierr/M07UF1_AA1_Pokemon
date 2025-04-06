package com.davidreyes.m7uf1_pokemon.ui.features.pokemons

import android.net.Uri
import android.util.Log
import androidx.compose.ui.graphics.Color
import com.davidreyes.m7uf1_pokemon.models.Tipo


data class TipoUiState(
    val id : String = "-1",
    val nombre : String = "",
    val imagen : Uri = Uri.EMPTY,
    val color : Color = Color.Transparent
)

fun Tipo.toTipoUiState(): TipoUiState {
    Log.d("ColorViewModel", color)
    return TipoUiState(
        id = id,
        nombre = nombre,
        color = color.toColor(),
        imagen = imagen
    )
}

fun String.toColor(): Color =
    Color(this.toLong(16))