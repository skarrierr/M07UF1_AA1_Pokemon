package com.davidreyes.m7uf1_pokemon.data.mocks.tipo
import com.davidreyes.m7uf1_pokemon.data.mocks.tipo.TipoMock
import javax.inject.Inject

class TipoDaoMock @Inject constructor() {
    private val tipos: List<TipoMock> = listOf(
        TipoMock(
            id = "1",
            nombre = "Planta",
            imagen = "https://cdn.pixabay.com/photo/2018/05/20/01/41/pokemon-3414810_640.png",
            color = "FF80D04D"
        ),
        TipoMock(
            id = "2",
            nombre = "Agua",
            imagen = "https://cdn.pixabay.com/photo/2018/05/21/13/06/pokemon-3418257_1280.png",
            color = "FF01A0FB"
        ),
        TipoMock(
            id = "3",
            nombre = "Fuego",
            imagen = "https://cdn.pixabay.com/photo/2018/05/20/01/40/pokemon-3414807_1280.png",
            color = "FFAB1F23"
        ),
        TipoMock(
            id = "4",
            nombre = "Normal",
            imagen = "https://cdn.pixabay.com/photo/2018/05/20/21/00/pokemon-3416764_960_720.png",
            color = "FF9FA19F"
        ),
        TipoMock(
            id = "5",
            nombre = "Fantasma",
            imagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Pok%C3%A9mon_Poison_Type_Icon.svg/2048px-Pok%C3%A9mon_Poison_Type_Icon.svg.png",
            color = "FF531884"
        )
    )

    fun get(): List<TipoMock> = tipos
}