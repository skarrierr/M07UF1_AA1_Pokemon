package com.davidreyes.m7uf1_pokemon.data

import androidx.core.net.toUri
import com.davidreyes.m7uf1_pokemon.data.firestore.FirestoreConstants
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonDao
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonFirestore
import com.davidreyes.m7uf1_pokemon.data.firestore.tipo.TipoDao
import com.davidreyes.m7uf1_pokemon.data.mocks.pokemon.PokemonDaoMock
import com.davidreyes.m7uf1_pokemon.models.Pokemon
import com.davidreyes.m7uf1_pokemon.models.Tipo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val dao: PokemonDao,
    private val tipoDao: TipoDao
) {
    suspend fun get(): List<Pokemon> = withContext(Dispatchers.IO) {
        dao.get().map { it.toPokemon() }
    }

    suspend fun get(id: String): Pokemon? = withContext(Dispatchers.IO) {
        dao.get(id)?.toPokemon()
    }

    suspend fun count(): Int = withContext(Dispatchers.IO) {
        dao.count()
    }

    suspend fun insert(pokemon: Pokemon) = withContext(Dispatchers.IO) {
        dao.insert(pokemon.toPokemonFirestore())
    }

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