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

fun Pokemon.toPokemonFirestore(): PokemonFirestore =
    PokemonFirestore(
        id = id,
        nombre = nombre,
        nivel = nivel,
        vida = vida,
        ataque = ataque,
        defensa = defensa,
        velocidad = velocidad,
        tipo = tipo.id,
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
        tipo = Tipo(id = id),
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
        color = color

    )

fun Tipo.toTipoFirestore(): TipoFirestore =
    TipoFirestore(
        id = id,
        nombre = nombre,
        imagen = imagen.toString(),
        color = color
    )

fun TipoMock.toTipo(): Tipo =
    Tipo(
        id = id,
        nombre = nombre,
        imagen = imagen.toUri(),
        color = color

    )

fun Equipo.toEquipoFirestore(): EquipoFirestore =
    EquipoFirestore(
        id = id,
        nombre = nombre,
        pokemons = pokemons.toPokemonsString().toList()
    )

fun EquipoMock.toEquipo(): Equipo =
    Equipo(
        id = id,
        nombre = nombre,
        pokemons = pokemons.toPokemons().toSet()

    )

fun Set<Pokemon>.toPokemonsString(): List<String> =
    this.map { it.id }

fun List<String>.toPokemons(): List<Pokemon> =
    this.map { Pokemon(id = it) }
