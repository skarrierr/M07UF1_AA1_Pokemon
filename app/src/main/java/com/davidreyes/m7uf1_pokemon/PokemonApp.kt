package com.davidreyes.m7uf1_pokemon

import android.app.Application
import com.davidreyes.m7uf1_pokemon.data.firestore.objeto.ObjetoDao
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonDao
import com.davidreyes.m7uf1_pokemon.data.mocks.objeto.ObjetoDaoMock
import com.davidreyes.m7uf1_pokemon.data.mocks.pokemon.PokemonDaoMock
import com.davidreyes.m7uf1_pokemon.data.toPokemon
import com.davidreyes.m7uf1_pokemon.data.toPokemonFirestore
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class PokemonApp: Application() {
    @Inject
    lateinit var pokemonDaoMock: PokemonDaoMock
   // lateinit var objetoDaoMock: ObjetoDaoMock


    @Inject
    lateinit var pokemonDao: PokemonDao
    //lateinit var objetoDao: ObjetoDao

    override fun onCreate() {
        super.onCreate()
        runBlocking {
            if (pokemonDao.count() == 0)
                pokemonDaoMock.get().forEach {
                    pokemonDao.insert(it.toPokemon().toPokemonFirestore())
                }
           /* if (objetoDao.count() == 0)
                objetoDaoMock.get().forEach {
                    objetoDao.insert(it.toObjeto().toObjetoFirestore())
                }*/
        }
    }
}