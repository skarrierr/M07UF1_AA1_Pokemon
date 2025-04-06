package com.davidreyes.m7uf1_pokemon.ui.features.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.davidreyes.m7uf1_pokemon.R
import com.davidreyes.m7uf1_pokemon.ui.composables.TextBodyLarge

@Composable
fun Login(
    modifier: Modifier = Modifier,
    loginState: LoginUiState,
    onLoginEvent: (LoginEvent) -> Unit,
    onNavigateToRegister: () ->  Unit,
    onNavigateToPokemons: () ->  Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            label = {
                TextBodyLarge(text = stringResource(id = R.string.email))
            },
            value = loginState.email,
            onValueChange = {
                onLoginEvent(LoginEvent.OnCambiarEmail(it))
            }
        )
        TextField(
            label = {
                TextBodyLarge(text = stringResource(id = R.string.contrasenya))
            },
            value = loginState.contrasenya,
            onValueChange = {
                onLoginEvent(LoginEvent.OnCambiarContrasenya(it))
            }
        )
        TextBodyLarge(
            modifier = Modifier.clickable(onClick = onNavigateToRegister),
            text = stringResource(R.string.register)
        )
        Button(
            onClick = { onLoginEvent(LoginEvent.OnIniciarSesion(onNavigateToPokemons)) }
        ) {
            TextBodyLarge(text = stringResource(R.string.login))
        }
    }
}