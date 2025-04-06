package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.davidreyes.m7uf1_pokemon.ui.features.register.Register
import com.davidreyes.m7uf1_pokemon.ui.features.register.RegisterViewModel
import kotlinx.serialization.Serializable


@Serializable
object RegisterRoute

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    this.navigate(RegisterRoute, navOptions)
}

fun NavGraphBuilder.registerScreen(
    vm: RegisterViewModel,
    onNavigateToLogin: () -> Unit,
    onNavigateToPokemons: () -> Unit
) {
    composable<RegisterRoute> {
        Register(
            registerState = vm.registerState,
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToPokemons = onNavigateToPokemons,
            onRegisterEvent = vm::onRegisterEvent
        )
    }
}