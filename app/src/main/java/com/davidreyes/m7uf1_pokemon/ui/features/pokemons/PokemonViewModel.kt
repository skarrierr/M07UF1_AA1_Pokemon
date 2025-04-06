package com.davidreyes.m7uf1_pokemon.ui.features.pokemons

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidreyes.m7uf1_pokemon.data.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
):ViewModel() {
    var pokemons: List<PokemonUiState> = mutableStateListOf()
    private fun loadPokemons(){
        viewModelScope.launch {
            pokemons = pokemonRepository.get().map { it.toPokemonUiState() }
        }

    }

}