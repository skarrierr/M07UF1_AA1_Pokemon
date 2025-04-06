package com.davidreyes.m7uf1_pokemon.data

import android.net.Uri
import androidx.compose.ui.graphics.Color
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonFirestore
import com.davidreyes.m7uf1_pokemon.models.Pokemon
import androidx.core.net.toUri
import com.davidreyes.m7uf1_pokemon.data.firestore.equipo.EquipoFirestore
import com.davidreyes.m7uf1_pokemon.data.firestore.objeto.ObjetoFirestore
import com.davidreyes.m7uf1_pokemon.data.firestore.tipo.TipoFirestore
import com.davidreyes.m7uf1_pokemon.data.mocks.equipo.EquipoMock
import com.davidreyes.m7uf1_pokemon.data.mocks.objeto.ObjetoMock
import com.davidreyes.m7uf1_pokemon.data.mocks.pokemon.PokemonMock
import com.davidreyes.m7uf1_pokemon.data.mocks.tipo.TipoMock
import com.davidreyes.m7uf1_pokemon.models.Equipo
import com.davidreyes.m7uf1_pokemon.models.Objeto
import com.davidreyes.m7uf1_pokemon.models.Tipo

fun PokemonFirestore.toPokemon(): Pokemon =
    Pokemon(
        id = id,
        nombre = nombre,
        nivel = nivel,
        vida = vida,
        ataque = ataque,
        defensa = defensa,
        velocidad = velocidad,
        tipo = tipo,
        imagen = imagen.toUri()

    )
fun Pokemon.toPokemonFirestore(): PokemonFirestore =
    PokemonFirestore(
        id = id,
        nombre = nombre,
        nivel = nivel,
        vida = vida,
        ataque = ataque,
        defensa = defensa,
        velocidad = velocidad,
        tipo = tipo,
        imagen = imagen.toString()

    )

fun PokemonMock.toPokemon(): Pokemon =
    Pokemon(
        id = id,
        nombre = nombre,
        nivel = nivel,
        vida = vida,
        ataque = ataque,
        defensa = defensa,
        velocidad = velocidad,
        tipo = tipo,
        imagen = imagen.toUri()

    )

fun ObjetoFirestore.toObjeto(): Objeto =
    Objeto(
        id = id,
        nombre = nombre,
        precio = precio,
        imagen = imagen.toUri()

    )

fun Objeto.toObjetoFirestore(): ObjetoFirestore =
    ObjetoFirestore(
        id = id,
        nombre = nombre,
        precio = precio,
        imagen = imagen.toString()

    )

fun ObjetoMock.toObjeto(): Objeto =
    Objeto(
        id = id,
        nombre = nombre,
        precio = precio,
        imagen = imagen.toUri()

    )

fun TipoFirestore.toTipo(): Tipo =
    Tipo(
        id = id,
        nombre = nombre,
        imagen = imagen.toUri(),
        color = color.toColor(),

    )

fun Tipo.toTipoFirestore(): TipoFirestore =
    TipoFirestore(
        id = id,
        nombre = nombre,
        imagen = imagen.toString(),
        color = color.toString()
    )

fun TipoMock.toTipo(): Tipo =
    Tipo(
        id = id,
        nombre = nombre,
        imagen = imagen.toUri(),
        color = color.toColor()

    )

fun EquipoFirestore.toEquipo(): Equipo =
    Equipo(
        id = id,
        nombre = nombre,
        pokemons = pokemons.toSet()
        )

fun Equipo.toEquipoFirestore(): EquipoFirestore =
    EquipoFirestore(
        id = id,
        nombre = nombre,
        pokemons = pokemons.toList()
    )

fun EquipoMock.toEquipo(): Equipo =
    Equipo(
        id = id,
        nombre = nombre,
        pokemons = pokemons.toSet()

    )


fun String.toColor(): Color =
    Color(this.toLong(16))