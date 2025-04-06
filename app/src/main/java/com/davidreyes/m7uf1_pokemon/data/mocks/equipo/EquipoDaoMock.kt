package com.davidreyes.m7uf1_pokemon.data.mocks.equipo
import com.davidreyes.m7uf1_pokemon.data.mocks.equipo.EquipoMock
import javax.inject.Inject


class EquipoDaoMock @Inject constructor() {
    private val equipos: List<EquipoMock> = listOf(
        EquipoMock(
            id = "1",
            nombre = "Jugador 1",
            pokemons = listOf(1, 2, 5)
        ),
        EquipoMock(
            id = "2",
            nombre = "Jugador 2",
            pokemons = listOf(3, 4, 6)
        )
    )

    fun get(): List<EquipoMock> = equipos
}