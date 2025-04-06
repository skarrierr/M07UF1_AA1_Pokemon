package com.davidreyes.m7uf1_pokemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.davidreyes.m7uf1_pokemon.ui.features.equipos.EquipoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.loading.LoadingViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.login.LoginViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.objetos.ObjetoViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.pokemons.PokemonViewModel
import com.davidreyes.m7uf1_pokemon.ui.features.register.RegisterViewModel

@Composable
fun PokemonNavHost() {
    val navController: NavHostController = rememberNavController()
    val vmEquipo: EquipoViewModel = hiltViewModel()
    val vmObjeto: ObjetoViewModel = hiltViewModel()
    val vmPokemon: PokemonViewModel = hiltViewModel()
    val vmLoading: LoadingViewModel = hiltViewModel()
    val vmLogin: LoginViewModel = hiltViewModel()
    val vmRegister: RegisterViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = LoadingRoute
    ) {
        loadingScreen(
            vm = vmLoading,
            onNavigateToPokemons = {
                navController.navigateToPokemon()
            },
            onNavigateToLogin = {
                navController.navigateToLogin()
            }
        )
        registerScreen(
            vm = vmRegister,
            onNavigateToPokemons = {
                navController.navigateToPokemon()
            },
            onNavigateToLogin = {
                navController.navigateToLogin()
            }
        )
        loginScreen(
            vm = vmLogin,
            onNavigateToPokemons = {
                navController.navigateToPokemon()
            },
            onNavigateToRegister = {
                navController.navigateToRegister()
            }
        )
        equipoScreen(
            vm = vmEquipo,
            onNavigateToPokemons = {
                navController.navigateToPokemon()
            },
            onNavigateToObjetos = {
                navController.navigateToObjetos()
            }
        )
        objetosScreen(
            vm = vmObjeto,
            onNavigateToPokemons = {
                navController.navigateToPokemon()
            },
            onNavigateToEquipos = {
                navController.navigateToEquipos()
            }
        )
        pokemonsScreen(
            vm = vmPokemon,
            onNavigateToEquipos = {
                navController.navigateToEquipos()
            },
            onNavigateToObjetos = {
                navController.navigateToObjetos()
            }
        )
    }
}