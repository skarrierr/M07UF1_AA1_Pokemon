package com.davidreyes.m7uf1_pokemon.ui.features.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    onLoadingEvent: (LoadingEvent) -> Unit,
    onNavigateToPokemons: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        onLoadingEvent(
            LoadingEvent.OnManageSession(
                onNavigateToPokemons = onNavigateToPokemons,
                onNavigateToLogin = onNavigateToLogin
            )
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}