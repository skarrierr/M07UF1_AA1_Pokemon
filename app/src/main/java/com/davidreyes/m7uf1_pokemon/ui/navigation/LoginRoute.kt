package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.davidreyes.m7uf1_pokemon.ui.features.loading.LoadingScreen
import com.davidreyes.m7uf1_pokemon.ui.features.loading.LoadingViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.login.Login
import com.davidreyes.m7uf1_pokemon.ui.features.login.LoginViewModel
import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(LoginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
    vm: LoginViewModel,
    onNavigateToRegister: () -> Unit,
    onNavigateToPokemons: () -> Unit
) {
    composable<LoginRoute> {
        Login(
            loginState = vm.loginState,
            onLoginEvent = vm::onLoginEvent,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToPokemons = onNavigateToPokemons
        )
    }
}