package com.davidreyes.m7uf1_pokemon.data

import com.davidreyes.m7uf1_pokemon.data.firestore.objeto.ObjetoDao
import com.davidreyes.m7uf1_pokemon.models.Objeto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ObjetoRepository @Inject constructor(
    private val dao: ObjetoDao
) {
    suspend fun get(): List<Objeto> = withContext(Dispatchers.IO) {
        dao.get().map { it.toObjeto() }
    }

    suspend fun get(id: String): Objeto? = withContext(Dispatchers.IO) {
        dao.get(id)?.toObjeto()
    }

    suspend fun count(): Int = withContext(Dispatchers.IO) {
        dao.count()
    }



}