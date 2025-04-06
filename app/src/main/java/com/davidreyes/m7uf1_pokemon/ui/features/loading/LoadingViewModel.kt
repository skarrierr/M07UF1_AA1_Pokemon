package com.davidreyes.m7uf1_pokemon.ui.features.loading

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidreyes.m7uf1_pokemon.data.services.authetication.AuthServiceImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val authService: AuthServiceImplementation
): ViewModel() {
    private fun manageSession(
        onNavigateToPokemons: () -> Unit,
        onNavigateToLogin: () -> Unit
    ) {
        viewModelScope.launch {
            val isUserLoggedIn: Boolean = authService.isUserLoggedIn()

            if(isUserLoggedIn) {
                authService.observeUserLoggedIn().await()
                onNavigateToPokemons()
            } else {
                onNavigateToLogin()
                Log.d("isUserLoggedIn", "$isUserLoggedIn")
            }
        }
    }

    fun onLoadingEvent(event: LoadingEvent) {
        when(event) {
            is LoadingEvent.OnManageSession -> {
                manageSession(
                    onNavigateToPokemons = event.onNavigateToPokemons,
                    onNavigateToLogin = event.onNavigateToLogin
                )
            }
        }
    }
}