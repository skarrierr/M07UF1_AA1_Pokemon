package com.davidreyes.m7uf1_pokemon.ui.features.objetos

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidreyes.m7uf1_pokemon.data.ObjetoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObjetoViewModel @Inject constructor(
    private val objetoRepository: ObjetoRepository
): ViewModel() {
    var objetosState:List<ObjetoUiState> = mutableStateListOf()

    private fun loadObjetos(){
        viewModelScope.launch {
            objetosState = objetoRepository.get().map { it.toObjetoUiState() }
        }

    }

    init {
        loadObjetos()
    }
}
