package com.davidreyes.m7uf1_pokemon.data.mocks.pokemon
import com.davidreyes.m7uf1_pokemon.data.mocks.pokemon.PokemonMock
import javax.inject.Inject

class PokemonDaoMock @Inject constructor() {
    private val pokemons: List<PokemonMock> =
        listOf(
            PokemonMock(
                id = "1",
                nombre = "Bulbasaur",
                imagen = "https://pngimg.com/d/pokemon_PNG52.png",
                nivel = 1,
                vida = 100,
                ataque = 40,
                defensa = 50,
                velocidad = 20,
                tipo = 1 
            ),
            PokemonMock(
                id = "2",
                nombre = "Charmander",
                imagen = "https://pngimg.com/d/pokemon_PNG125.png",
                nivel = 3,
                vida = 100,
                ataque = 55,
                defensa = 45,
                velocidad = 30,
                tipo = 3
            ),
            PokemonMock(
                id = "3",
                nombre = "Caterpie",
                imagen = "https://purepng.com/public/uploads/thumbnail/purepng.com-pokemonpokemonpocket-monsterspokemon-franchisefictional-speciesone-pokemonmany-pokemonone-pikachu-1701527786833noalt.png",
                nivel = 1,
                vida = 100,
                ataque = 35,
                defensa = 25,
                velocidad = 15,
                tipo = 1
            ),
            PokemonMock(
                id = "4",
                nombre = "Jigglypuff",
                imagen = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/039.png",
                nivel = 4,
                vida = 100,
                ataque = 60,
                defensa = 40,
                velocidad = 30,
                tipo = 4
            ),
            PokemonMock(
                id = "5",
                nombre = "Squirtle",
                imagen = "https://pngimg.com/d/pokemon_PNG116.png",
                nivel = 1,
                vida = 100,
                ataque = 35,
                defensa = 40,
                velocidad = 40,
                tipo = 2
            ),
            PokemonMock(
                id = "5",
                nombre = "Gengar",
                imagen = "https://archives.bulbagarden.net/media/upload/thumb/4/47/0094Gengar.png/640px-0094Gengar.png",
                nivel = 3,
                vida = 100,
                ataque = 60,
                defensa = 30,
                velocidad = 30,
                tipo = 5
            )
        )
    
    fun get(): List<PokemonMock> = pokemons
}