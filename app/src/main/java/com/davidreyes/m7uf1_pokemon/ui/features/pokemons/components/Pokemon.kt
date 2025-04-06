package com.davidreyes.m7uf1_pokemon.ui.features.pokemons.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.davidreyes.m7uf1_pokemon.ui.composables.TextBodyLarge
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonUiState

@Composable
fun Pokemon(
    modifier: Modifier = Modifier,
    pokemonState: PokemonUiState
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp),
            model = pokemonState.imagen,
            contentScale = ContentScale.Crop,
            contentDescription = pokemonState.nombre
        )
        TextBodyLarge(
            text = pokemonState.nombre
        )
    }
}