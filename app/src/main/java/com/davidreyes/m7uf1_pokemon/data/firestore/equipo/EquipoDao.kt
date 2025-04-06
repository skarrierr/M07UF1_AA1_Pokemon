package com.davidreyes.m7uf1_pokemon.data.firestore.equipo

import com.davidreyes.m7uf1_pokemon.data.firestore.FirestoreConstants
import com.davidreyes.m7uf1_pokemon.data.firestore.tipo.TipoFirestore
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class EquipoDao @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun get(): List<EquipoFirestore> {
        return firestore
            .collection(FirestoreConstants.Equipo.COLLECTION)
            .get()
            .await()
            .documents.mapNotNull { document ->
                document.toObject(EquipoFirestore::class.java)
            }
    }

    suspend fun get(id: String): EquipoFirestore? {
        return firestore
            .collection(FirestoreConstants.Equipo.COLLECTION)
            .document(id)
            .get()
            .await()?.toObject(EquipoFirestore::class.java)
    }

    fun update(equipo: EquipoFirestore) {
        firestore
            .collection(FirestoreConstants.Equipo.COLLECTION)
            .document(equipo.id)
            .set(equipo, SetOptions.merge())
    }

    suspend fun count(): Int {
        val querySnapshot = firestore
            .collection(FirestoreConstants.Equipo.COLLECTION)
            .get()
            .await()

        return querySnapshot.size()
    }
}