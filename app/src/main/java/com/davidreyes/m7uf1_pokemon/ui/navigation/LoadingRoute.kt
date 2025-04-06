package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.davidreyes.m7uf1_pokemon.ui.features.loading.LoadingScreen
import com.davidreyes.m7uf1_pokemon.ui.features.loading.LoadingViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetosScreen
import kotlinx.serialization.Serializable

@Serializable
object LoadingRoute

fun NavController.navigateToLoading(navOptions: NavOptions? = null) {
    this.navigate(LoadingRoute, navOptions)
}

fun NavGraphBuilder.loadingScreen(
    vm: LoadingViewModel,
    onNavigateToPokemons: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    composable<LoadingRoute> {
        LoadingScreen(
            onLoadingEvent = vm::onLoadingEvent,
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToPokemons = onNavigateToPokemons
        )
    }
}