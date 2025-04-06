package com.davidreyes.m7uf1_pokemon.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CrueltyFree
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    onNavigateToPokemons: () -> Unit,
    onNavigateToObjetos: () -> Unit,
    onNavigateToEquipos: () -> Unit
) {
    @Immutable
    data class NavOption(
        val icon: ImageVector,
        val description: String? = null,
        val title: String,
        val onClick: () -> Unit
    )

    val listNavOptions: List<NavOption> = listOf(
        NavOption(
            icon = Icons.Filled.Pets,
            description = "Pokemons",
            title = "Pokemons",
            onClick = onNavigateToPokemons
        ),
        NavOption(
            icon = Icons.Filled.Groups,
            description = "Equipos",
            title = "Equipos",
            onClick = onNavigateToEquipos
        ),
        NavOption(
            icon = Icons.Filled.Inventory,
            description = "Objetos",
            title = "Objetos",
            onClick = onNavigateToObjetos
        )
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listNavOptions.forEachIndexed { index, button ->
                val isSelected: Boolean = selectedPage == index

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = button.icon,
                            contentDescription = button.description,
                            tint = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurface.copy(
                                alpha = 0.5f
                            )
                        )
                    },
                    label = {
                        Text(
                            text = button.title,
                            color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurface.copy(
                                alpha = 0.5f
                            )
                        )
                    },
                    colors =
                        NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                            selectedIconColor = MaterialTheme.colorScheme.onSurface,
                            selectedTextColor = MaterialTheme.colorScheme.onSurface,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurface
                        ),
                    selected = isSelected,
                    onClick = button.onClick
                )
            }
        }
    }
}