package com.davidreyes.m7uf1_pokemon.data.mocks.objeto
import com.davidreyes.m7uf1_pokemon.data.mocks.objeto.ObjetoMock
import javax.inject.Inject

class ObjetoDaoMock @Inject constructor() {
    private val objetos: List<ObjetoMock> = listOf(
        ObjetoMock(
            id = "1",
            nombre = "Master ball",
            precio = 50,
            imagen = "https://pokemon4ever.org/cdn/shop/products/item_0001.png?v=1674083306"
        ),
        ObjetoMock(
            id = "2",
            nombre = "Casco dentado",
            precio = 35,
            imagen = "https://images.wikidexcdn.net/mwuploads/wikidex/3/33/latest/20230122002043/Casco_dentado_EP.png"
        ),
        ObjetoMock(
            id = "3",
            nombre = "Poción máxima",
            precio = 40,
            imagen = "https://pkm.gg/cdn/shop/files/item_0024.png?v=1730118033"
        ),
        ObjetoMock(
            id = "4",
            nombre = "Luna ball",
            precio = 55,
            imagen = "https://pokemon4ever.org/cdn/shop/products/item_0498.png?v=1675553961"
        ),
        ObjetoMock(
            id = "5",
            nombre = "Velocidad X",
            precio = 15,
            imagen = "https://archives.bulbagarden.net/media/upload/5/5f/Bag_X_Speed_SV_Sprite.png"
        )
    )

    fun get(): List<ObjetoMock> = objetos
}