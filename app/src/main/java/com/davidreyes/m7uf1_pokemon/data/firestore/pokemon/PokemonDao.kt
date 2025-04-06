package com.davidreyes.m7uf1_pokemon.data.firestore.pokemon

import com.davidreyes.m7uf1_pokemon.data.firestore.FirestoreConstants
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PokemonDao  @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun get(): List<PokemonFirestore> {
        return firestore
            .collection(FirestoreConstants.Pokemon.COLLECTION)
            .get()
            .await()
            .documents.mapNotNull { document ->
                document.toObject(PokemonFirestore::class.java)
            }
    }

    suspend fun get(id: String): PokemonFirestore? {
        return firestore
            .collection(FirestoreConstants.Pokemon.COLLECTION)
            .document(id)
            .get()
            .await()?.toObject(PokemonFirestore::class.java)
    }

    suspend fun count(): Int {
        val querySnapshot = firestore
            .collection(FirestoreConstants.Pokemon.COLLECTION)
            .get()
            .await()

        return querySnapshot.size()
    }

    fun insert(pokemon: PokemonFirestore) {
        firestore
            .collection(FirestoreConstants.Pokemon.COLLECTION)
            .document(pokemon.id)
            .set(pokemon)
    }
}