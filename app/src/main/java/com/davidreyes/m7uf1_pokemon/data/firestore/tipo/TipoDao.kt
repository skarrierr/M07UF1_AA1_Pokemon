package com.davidreyes.m7uf1_pokemon.data.firestore.tipo

import com.davidreyes.m7uf1_pokemon.data.firestore.FirestoreConstants
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TipoDao @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun get(): List<TipoFirestore> {
        return firestore
            .collection(FirestoreConstants.Tipo.COLLECTION)
            .get()
            .await()
            .documents.mapNotNull { document ->
                document.toObject(TipoFirestore::class.java)
            }
    }

    suspend fun get(id: String): TipoFirestore? {
        return firestore
                .collection(FirestoreConstants.Tipo.COLLECTION)
                .document(id)
                .get()
                .await()?.toObject(TipoFirestore::class.java)
    }

    suspend fun count(): Int {
        val querySnapshot = firestore
            .collection(FirestoreConstants.Pokemon.COLLECTION)
            .get()
            .await()

        return querySnapshot.size()
    }
}