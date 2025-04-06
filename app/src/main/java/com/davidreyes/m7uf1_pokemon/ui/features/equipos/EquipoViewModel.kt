package com.davidreyes.m7uf1_pokemon.ui.features.equipos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.davidreyes.m7uf1_pokemon.data.EquipoRepository
import com.davidreyes.m7uf1_pokemon.data.PokemonRepository
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonUiState
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.toPokemonUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipoViewModel @Inject constructor(
    private val equipoRepository: EquipoRepository,
    private val pokemonRepository: PokemonRepository
): ViewModel() {
    var equiposState= mutableStateListOf<EquipoUiState>()
        private set
    var pokemonsSeleccionadosState = mutableStateListOf<PokemonUiState>()
        private set
    var pokemonsState = mutableStateListOf<PokemonUiState>()
        private set
    var equipoSeleccionadoState: EquipoUiState? by mutableStateOf(null)
        private set
    var mostrarBottomSheet: Boolean by mutableStateOf(false)
        private set

    private fun loadEquipos(){
        viewModelScope.launch {
            val equipos = equipoRepository.get().map { it.toEquipoUiState() }.toMutableStateList()
            equiposState.addAll(equipos)
        }
    }

    private fun loadPokemons(){
        viewModelScope.launch {
            val pokemons = pokemonRepository.get().map { it.toPokemonUiState() }.toMutableStateList()
            pokemonsState.addAll(pokemons)
        }
    }

    init {
        loadEquipos()
        loadPokemons()
    }

    fun onEquipoEvent(event: EquipoEvent) {
        when (event){
            is EquipoEvent.OnActualizarEquipo -> {
                val indice = equiposState.indexOfFirst { it.id == equipoSeleccionadoState?.id }

                if(indice != -1) {
                    equiposState[indice] = equiposState[indice].copy(pokemons = pokemonsSeleccionadosState.toList())
                    viewModelScope.launch {
                        equipoRepository.update(equiposState[indice].toEquipo())
                    }
                }
            }
            is EquipoEvent.OnClickPokemon -> {
                val existe = pokemonsSeleccionadosState.any { it.id == event.pokemon.id }

                if(existe)
                    pokemonsSeleccionadosState.removeIf { it.id == event.pokemon.id }
                else
                    pokemonsSeleccionadosState.add(event.pokemon)
            }

            is EquipoEvent.OnSeleccionarEquipo -> {
                if(event.equipo.id != equipoSeleccionadoState?.id) equipoSeleccionadoState = event.equipo else equipoSeleccionadoState = null
            }

            is EquipoEvent.OnMostrarPokemons -> {
                val indice = equiposState.indexOfFirst { it.id == equipoSeleccionadoState?.id }

                if(indice != -1)
                    pokemonsSeleccionadosState.addAll(equiposState[indice].pokemons)

                pokemonsSeleccionadosState.clear()
                mostrarBottomSheet = true
            }

            is EquipoEvent.OnOcultarPokemons -> {
                mostrarBottomSheet = false
            }
        }
    }

}
