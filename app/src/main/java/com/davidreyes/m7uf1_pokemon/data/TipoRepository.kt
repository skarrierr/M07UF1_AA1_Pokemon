package com.davidreyes.m7uf1_pokemon.data

import com.davidreyes.m7uf1_pokemon.data.firestore.tipo.TipoDao
import com.davidreyes.m7uf1_pokemon.models.Tipo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TipoRepository @Inject constructor(
    private val dao: TipoDao
) {
    suspend fun get(): List<Tipo> = withContext(Dispatchers.IO) {
        dao.get().map { it.toTipo() }
    }

    suspend fun get(id: String): Tipo? = withContext(Dispatchers.IO) {
        dao.get(id)?.toTipo()
    }

    suspend fun count(): Int = withContext(Dispatchers.IO) {
        dao.count()
    }



}