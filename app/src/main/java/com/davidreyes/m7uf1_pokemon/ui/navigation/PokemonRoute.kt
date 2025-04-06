package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetosScreen
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonsScreen
import kotlinx.serialization.Serializable

@Serializable
object PokemonsRoute

fun NavController.navigateToPokemon(navOptions: NavOptions? = null) {
    this.navigate(PokemonsRoute, navOptions)
}

fun NavGraphBuilder.pokemonsScreen(
    vm: PokemonViewModel,
    onNavigateToEquipos: () -> Unit,
    onNavigateToObjetos: () -> Unit
) {
    composable<PokemonsRoute> {
        PokemonsScreen(
            pokemonsState = vm.pokemonsState,
            onNavigateToEquipos = onNavigateToEquipos,
            onNavigateToObjetos = onNavigateToObjetos
        )
    }
}