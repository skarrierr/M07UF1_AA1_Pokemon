package com.davidreyes.m7uf1_pokemon.ui.features.equipos

import com.davidreyes.m7uf1_pokemon.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.davidreyes.m7uf1_pokemon.ui.components.NavBar
import com.davidreyes.m7uf1_pokemon.ui.components.TopBar
import com.davidreyes.m7uf1_pokemon.ui.composables.TextBodyLarge
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.components.Equipo
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.components.PokemonItem
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonBottomSheet(
    modifier: Modifier = Modifier,
    pokemonsState: List<PokemonUiState>,
    pokemonsSeleccionadosState: List<PokemonUiState>,
    onGuardar: () -> Unit,
    onClick: (PokemonUiState) -> Unit,
    onDismissRequest: () -> Unit,
    sheetState: SheetState
) {
    ModalBottomSheet(
        modifier = modifier,
        tonalElevation = 0.dp,
        onDismissRequest = onDismissRequest,
        sheetState = sheetState
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
            ) {
                items(pokemonsState) { pokemon ->
                    PokemonItem(
                        pokemonState = pokemon,
                        onClick = { onClick(pokemon) },
                        activado = pokemonsSeleccionadosState.any { it.id == pokemon.id }
                    )
                }
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onGuardar,
                enabled = pokemonsSeleccionadosState.isNotEmpty()
            ) {
                TextBodyLarge(text = stringResource(R.string.guardar))
            }
        }
    }
}

@Composable
fun BotonCambio(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Filled.ChangeCircle,
            contentDescription = "Editar pokemons"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EquiposScreen(
    modifier: Modifier = Modifier,
    equiposState: List<EquipoUiState>,
    pokemonsState: List<PokemonUiState>,
    equipoSeleccionadoState: EquipoUiState?,
    pokemonsSeleccionadosState: List<PokemonUiState>,
    mostrarBottomSheet: Boolean,
    onEquipoEvent: (EquipoEvent) -> Unit,
    onNavigateToPokemons: () -> Unit,
    onNavigateToObjetos: () -> Unit
) {
    val skipPartiallyExpanded: Boolean by remember { mutableStateOf(false) }
    val bottomSheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(R.string.equipos)
            )
        },
        bottomBar = {
            NavBar(
                selectedPage = 1,
                onNavigateToPokemons = onNavigateToPokemons,
                onNavigateToEquipos = {},
                onNavigateToObjetos = onNavigateToObjetos
            )
        },
        floatingActionButton = {
            if(equipoSeleccionadoState != null)
                BotonCambio { onEquipoEvent(EquipoEvent.OnMostrarPokemons) }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            equiposState.forEach { equipo ->
                Equipo(
                    modifier = Modifier.fillMaxWidth(),
                    equipoState = equipo,
                    onClick = { onEquipoEvent(EquipoEvent.OnSeleccionarEquipo(equipo)) }
                )
            }
        }
        if(mostrarBottomSheet) {
            PokemonBottomSheet(
                pokemonsState = pokemonsState,
                onDismissRequest = {
                    onEquipoEvent(EquipoEvent.OnOcultarPokemons)
                },
                sheetState = bottomSheetState,
                onGuardar = {
                    onEquipoEvent(EquipoEvent.OnActualizarEquipo)
                },
                onClick = {
                    onEquipoEvent(EquipoEvent.OnClickPokemon(it))
                },
                pokemonsSeleccionadosState = pokemonsSeleccionadosState
            )
        }
    }
}