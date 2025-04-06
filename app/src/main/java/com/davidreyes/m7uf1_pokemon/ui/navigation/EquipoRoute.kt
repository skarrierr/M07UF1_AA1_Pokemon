package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquipoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquiposScreen
import kotlinx.serialization.Serializable

@Serializable
object EquipoRoute

fun NavController.navigateToEquipos(navOptions: NavOptions? = null) {
    this.navigate(EquipoRoute, navOptions)
}

fun NavGraphBuilder.equipoScreen(
    vm: EquipoViewModel,
    onNavigateToPokemons: () -> Unit,
    onNavigateToObjetos: () -> Unit
) {
    composable<EquipoRoute> {
        EquiposScreen(
            equiposState = vm.equiposState,
            pokemonsState = vm.pokemonsState,
            onEquipoEvent = vm::onEquipoEvent,
            mostrarBottomSheet = vm.mostrarBottomSheet,
            pokemonsSeleccionadosState = vm.pokemonsSeleccionadosState,
            equipoSeleccionadoState = vm.equipoSeleccionadoState,
            onNavigateToObjetos = onNavigateToObjetos,
            onNavigateToPokemons = onNavigateToPokemons
        )
    }
}