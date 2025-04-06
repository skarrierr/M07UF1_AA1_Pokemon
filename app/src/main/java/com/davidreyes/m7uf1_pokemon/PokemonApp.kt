package com.davidreyes.m7uf1_pokemon

import android.app.Application
import com.davidreyes.m7uf1_pokemon.data.firestore.equipo.EquipoDao
import com.davidreyes.m7uf1_pokemon.data.firestore.objeto.ObjetoDao
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonDao
import com.davidreyes.m7uf1_pokemon.data.firestore.tipo.TipoDao
import com.davidreyes.m7uf1_pokemon.data.mocks.equipo.EquipoDaoMock
import com.davidreyes.m7uf1_pokemon.data.mocks.objeto.ObjetoDaoMock
import com.davidreyes.m7uf1_pokemon.data.mocks.pokemon.PokemonDaoMock
import com.davidreyes.m7uf1_pokemon.data.mocks.tipo.TipoDaoMock
import com.davidreyes.m7uf1_pokemon.data.toEquipo
import com.davidreyes.m7uf1_pokemon.data.toEquipoFirestore
import com.davidreyes.m7uf1_pokemon.data.toObjeto
import com.davidreyes.m7uf1_pokemon.data.toObjetoFirestore
import com.davidreyes.m7uf1_pokemon.data.toPokemon
import com.davidreyes.m7uf1_pokemon.data.toPokemonFirestore
import com.davidreyes.m7uf1_pokemon.data.toTipo
import com.davidreyes.m7uf1_pokemon.data.toTipoFirestore
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class PokemonApp: Application() {
    @Inject
    lateinit var pokemonDaoMock: PokemonDaoMock

    @Inject
    lateinit var objetoDaoMock: ObjetoDaoMock

    @Inject
    lateinit var equipoDaoMock: EquipoDaoMock

    @Inject
    lateinit var tipoDaoMock: TipoDaoMock


    @Inject
    lateinit var pokemonDao: PokemonDao

    @Inject
    lateinit var objetoDao: ObjetoDao

    @Inject
    lateinit var equipoDao: EquipoDao

    @Inject
    lateinit var tipoDao: TipoDao

    override fun onCreate() {
        super.onCreate()
        runBlocking {
            if (pokemonDao.count() == 0)
                pokemonDaoMock.get().forEach {
                    pokemonDao.insert(it.toPokemon().toPokemonFirestore())
                }
            if (objetoDao.count() == 0)
                objetoDaoMock.get().forEach {
                    objetoDao.insert(it.toObjeto().toObjetoFirestore())
                }
            if (equipoDao.count() == 0)
                equipoDaoMock.get().forEach {
                    equipoDao.insert(it.toEquipo().toEquipoFirestore())
                }
            if (tipoDao.count() == 0)
                tipoDaoMock.get().forEach {
                    tipoDao.insert(it.toTipo().toTipoFirestore())
                }
        }
    }
}