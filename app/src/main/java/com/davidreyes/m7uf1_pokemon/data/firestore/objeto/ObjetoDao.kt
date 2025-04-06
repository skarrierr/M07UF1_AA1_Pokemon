package com.davidreyes.m7uf1_pokemon.data.firestore.objeto

import com.davidreyes.m7uf1_pokemon.data.firestore.FirestoreConstants
import com.davidreyes.m7uf1_pokemon.data.firestore.equipo.EquipoFirestore
import com.davidreyes.m7uf1_pokemon.data.firestore.pokemon.PokemonFirestore
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ObjetoDao @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun get(): List<ObjetoFirestore> {
        return firestore
            .collection(FirestoreConstants.Objeto.COLLECTION)
            .get()
            .await()
            .documents.mapNotNull { document ->
                document.toObject(ObjetoFirestore::class.java)
            }
    }

    suspend fun get(id: String): ObjetoFirestore? {
        return firestore
            .collection(FirestoreConstants.Objeto.COLLECTION)
            .document(id)
            .get()
            .await()?.toObject(ObjetoFirestore::class.java)
    }

    suspend fun count(): Int {
        val querySnapshot = firestore
            .collection(FirestoreConstants.Objeto.COLLECTION)
            .get()
            .await()

        return querySnapshot.size()
    }

    fun insert(objeto: ObjetoFirestore) {
        firestore
            .collection(FirestoreConstants.Objeto.COLLECTION)
            .document(objeto.id)
            .set(objeto)
    }
}