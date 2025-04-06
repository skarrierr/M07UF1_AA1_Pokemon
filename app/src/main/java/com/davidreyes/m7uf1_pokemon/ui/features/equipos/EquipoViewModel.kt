package com.davidreyes.m7uf1_pokemon.ui.features.equipos

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.davidreyes.m7uf1_pokemon.data.EquipoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipoViewModel @Inject constructor(
    private val equipoRepository: EquipoRepository
): ViewModel() {
    var equipos:List<EquipoUiState> = mutableStateListOf()
    private fun loadEquipos(){
        viewModelScope.launch {
            equipos = equipoRepository.get().map { it.toEquipoUiState() }
        }

    }

}
