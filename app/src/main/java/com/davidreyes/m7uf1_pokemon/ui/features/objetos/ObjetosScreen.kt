package com.davidreyes.m7uf1_pokemon.ui.features.objetos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.davidreyes.m7uf1_pokemon.R
import com.davidreyes.m7uf1_pokemon.ui.components.NavBar
import com.davidreyes.m7uf1_pokemon.ui.components.TopBar
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquipoEvent
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.PokemonBottomSheet
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.components.Equipo
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.components.ObjetoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjetosScreen(
    modifier: Modifier = Modifier,
    objetosState: List<ObjetoUiState>,
    onNavigateToPokemons: () -> Unit,
    onNavigateToEquipos: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(id = R.string.objetos)
            )
        },
        bottomBar = {
            NavBar(
                selectedPage = 2,
                onNavigateToPokemons = onNavigateToPokemons,
                onNavigateToEquipos = onNavigateToEquipos,
                onNavigateToObjetos = {}
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            objetosState.forEach { objeto ->
                ObjetoItem(
                    objetoState = objeto
                )
            }
        }
    }
}