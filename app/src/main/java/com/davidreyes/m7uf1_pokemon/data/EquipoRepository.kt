package com.davidreyes.m7uf1_pokemon.data

import com.davidreyes.m7uf1_pokemon.data.firestore.equipo.EquipoDao
import com.davidreyes.m7uf1_pokemon.models.Equipo
import com.davidreyes.m7uf1_pokemon.models.Objeto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EquipoRepository @Inject constructor(
    private val dao: EquipoDao
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



}