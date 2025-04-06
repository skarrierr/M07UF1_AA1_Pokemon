package com.davidreyes.m7uf1_pokemon.ui.features.tipos

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidreyes.m7uf1_pokemon.data.TipoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TipoViewModel @Inject constructor(
    private val tipoRepository: TipoRepository
): ViewModel() {
    var tipos:List<TipoUiState> = mutableStateListOf()
    private fun loadTipos(){
        viewModelScope.launch {
            tipos = tipoRepository.get().map { it.toTipoUiState() }
        }

    }

}