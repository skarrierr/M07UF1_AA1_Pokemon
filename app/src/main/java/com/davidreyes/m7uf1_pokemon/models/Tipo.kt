package com.davidreyes.m7uf1_pokemon.models


import android.net.Uri
import androidx.compose.ui.graphics.Color

data class Tipo(

    val id : String = "-1",
    val nombre : String = "",
    val imagen : Uri = Uri.EMPTY,
    val color : String = ""

    )
