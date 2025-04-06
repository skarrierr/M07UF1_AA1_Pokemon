package com.davidreyes.m7uf1_pokemon.ui.features.tipos

import android.net.Uri
import com.davidreyes.m7uf1_pokemon.models.Objeto
import com.davidreyes.m7uf1_pokemon.models.Tipo


data class TipoUiState(
    val id : String = "-1",
    val nombre : String = "",
    val imagen : Uri = Uri.EMPTY,
    val color : String = ""
)
fun Tipo.toTipoUiState(): TipoUiState =
    TipoUiState(
        id = id,
        nombre = nombre,
        color = color.toString(),
        imagen = imagen
    )