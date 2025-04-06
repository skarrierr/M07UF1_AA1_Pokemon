package com.davidreyes.m7uf1_pokemon.data

import androidx.core.net.toUri
import com.davidreyes.m7uf1_pokemon.data.firestore.equipo.EquipoDao
import com.davidreyes.m7uf1_pokemon.data.firestore.equipo.EquipoFirestore
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonDao
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonFirestore
import com.davidreyes.m7uf1_pokemon.data.firestore.tipo.TipoDao
import com.davidreyes.m7uf1_pokemon.models.Equipo
import com.davidreyes.m7uf1_pokemon.models.Objeto
import com.davidreyes.m7uf1_pokemon.models.Pokemon
import com.davidreyes.m7uf1_pokemon.models.Tipo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EquipoRepository @Inject constructor(
    private val dao: EquipoDao,
    private val pokemonDao: PokemonDao,
    private val tipoDao: TipoDao
) {
    suspend fun get(): List<Equipo> = withContext(Dispatchers.IO) {
        dao.get().map { it.toEquipo() }
    }

    suspend fun get(id: String): Equipo? = withContext(Dispatchers.IO) {
        dao.get(id)?.toEquipo()
    }

    suspend fun count(): Int = withContext(Dispatchers.IO) {
        dao.count()
    }

    suspend fun insert(equipo: Equipo) = withContext(Dispatchers.IO) {
        dao.insert(equipo.toEquipoFirestore())
    }

    suspend fun update(equipo: Equipo) = withContext(Dispatchers.IO) {
        dao.update(equipo.toEquipoFirestore())
    }

    private suspend fun EquipoFirestore.toEquipo(): Equipo =
        Equipo(
            id = id,
            nombre = nombre,
            pokemons = pokemons.map { pokemonDao.get(it)?.toPokemon() ?: Pokemon() }.toSet()
        )

    private suspend fun PokemonFirestore.toPokemon(): Pokemon =
        Pokemon(
            id = id,
            nombre = nombre,
            nivel = nivel,
            vida = vida,
            ataque = ataque,
            defensa = defensa,
            velocidad = velocidad,
            tipo = tipoDao.get(tipo)?.toTipo() ?: Tipo(),
            imagen = imagen.toUri()
        )
}