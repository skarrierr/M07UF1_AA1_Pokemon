package com.davidreyes.m7uf1_pokemon.ui.features.equipos.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davidreyes.m7uf1_pokemon.ui.composables.TextBodyLarge
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquipoUiState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Equipo(
    modifier: Modifier = Modifier,
    equipoState: EquipoUiState,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextBodyLarge(
                fontWeight = FontWeight.Bold,
                text = equipoState.nombre
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                equipoState.pokemons.forEach { pokemon ->
                    TextBodyLarge(
                        text = pokemon.nombre
                    )
                }
            }
        }
    }
}