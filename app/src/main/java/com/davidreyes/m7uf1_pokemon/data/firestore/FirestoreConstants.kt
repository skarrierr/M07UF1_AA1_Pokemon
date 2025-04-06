package com.davidreyes.m7uf1_pokemon.data.firestore



object FirestoreConstants {
    object Pokemon {
        const val COLLECTION = "pokemons"
        object Fields {
            const val ID = "id"
            const val NOMBRE = "nombre"
            const val NIVEL = "nivel"
            const val VIDA = "vida"
            const val ATAQUE = "ataque"
            const val DEFENSA = "defensa"
            const val VELOCIDAD = "velocidad"
            const val TIPO = "tipo"
            const val IMAGEN = "imagen"
        }
    }

    object Objeto {
        const val COLLECTION = "objetos"
        object Fields {
            const val ID = "id"
            const val NOMBRE = "nombre"
            const val PRECIO = "precio"
            const val IMAGEN = "imagen"
        }
    }

    object Tipo {
        const val COLLECTION = "tipos"
        object Fields {
            const val ID = "id"
            const val NOMBRE = "nombre"
            const val COLOR = "color"
            const val IMAGEN = "imagen"
        }
    }

    object Equipo {
        const val COLLECTION = "equipos"
        object Fields {
            const val ID = "id"
            const val NOMBRE = "nombre"
            const val POKEMONS = "pokemons"
        }
    }

}