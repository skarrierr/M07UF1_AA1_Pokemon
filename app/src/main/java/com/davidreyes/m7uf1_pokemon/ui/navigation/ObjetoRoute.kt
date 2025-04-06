package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquipoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquiposScreen
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetosScreen
import kotlinx.serialization.Serializable

@Serializable
object ObjetosRoute

fun NavController.navigateToObjetos(navOptions: NavOptions? = null) {
    this.navigate(ObjetosRoute, navOptions)
}

fun NavGraphBuilder.objetosScreen(
    vm: ObjetoViewModel,
    onNavigateToPokemons: () -> Unit,
    onNavigateToEquipos: () -> Unit
) {
    composable<ObjetosRoute> {
        ObjetosScreen(
            objetosState = vm.objetosState,
            onNavigateToEquipos = onNavigateToEquipos,
            onNavigateToPokemons = onNavigateToPokemons
        )
    }
}