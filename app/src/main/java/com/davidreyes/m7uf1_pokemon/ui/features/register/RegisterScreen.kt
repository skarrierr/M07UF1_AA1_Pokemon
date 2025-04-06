package com.davidreyes.m7uf1_pokemon.ui.features.register

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
fun Register(
    modifier: Modifier = Modifier,
    registerState: RegisterUiState,
    onRegisterEvent: (RegisterEvent) -> Unit,
    onNavigateToLogin: () ->  Unit,
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
            value = registerState.email,
            onValueChange = {
                onRegisterEvent(RegisterEvent.OnCambiarEmail(it))
            }
        )
        TextField(
            label = {
                TextBodyLarge(text = stringResource(id = R.string.contrasenya))
            },
            value = registerState.contrasenya,
            onValueChange = {
                onRegisterEvent(RegisterEvent.OnCambiarContrasenya(it))
            }
        )
        TextField(
            label = {
                TextBodyLarge(text = stringResource(id = R.string.contrasenya))
            },
            value = registerState.repetirCotrasenya,
            onValueChange = {
                onRegisterEvent(RegisterEvent.OnCambiarContrasenya(it))
            }
        )
        TextBodyLarge(
            modifier = Modifier.clickable(onClick = onNavigateToLogin),
            text = stringResource(R.string.login)
        )
        Button(
            onClick = { onRegisterEvent(RegisterEvent.OnRegistrarse(onNavigateToPokemons)) }
        ) {
            TextBodyLarge(text = stringResource(R.string.register))
        }
    }
}