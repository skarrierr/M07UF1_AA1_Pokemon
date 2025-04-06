package com.davidreyes.m7uf1_pokemon.ui.features.pokemons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.davidreyes.m7uf1_pokemon.R
import com.davidreyes.m7uf1_pokemon.ui.components.NavBar
import com.davidreyes.m7uf1_pokemon.ui.components.TopBar
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.components.Pokemon
import kotlin.collections.forEach

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonsScreen(
    modifier: Modifier = Modifier,
    pokemonsState: List<PokemonUiState>,
    onNavigateToEquipos: () -> Unit,
    onNavigateToObjetos: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(R.string.pokemons)
            )
        },
        bottomBar = {
            NavBar(
                selectedPage = 0,
                onNavigateToPokemons = {},
                onNavigateToEquipos = onNavigateToEquipos,
                onNavigateToObjetos = onNavigateToObjetos
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
            pokemonsState.forEach { pokemon ->
                Pokemon(
                    pokemonState = pokemon
                )
            }
        }
    }
}