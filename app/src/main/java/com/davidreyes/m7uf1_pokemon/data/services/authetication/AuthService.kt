package com.davidreyes.m7uf1_pokemon.data.services.authetication

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.TaskCompletionSource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthService @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) {
    fun isUserLoggedIn(): Boolean = firebaseAuth.currentUser != null

    fun sendPasswordResetEmail(email: String): Task<Void> =
        firebaseAuth.sendPasswordResetEmail(email)

    fun signIn(email: String, password: String): Task<AuthResult> =
        firebaseAuth.signInWithEmailAndPassword(email, password)

    fun signUp(email: String, password: String): Task<AuthResult> =
        firebaseAuth.createUserWithEmailAndPassword(email, password)

    fun logOut() {
        firebaseAuth.signOut()
    }

    fun observeUserLoggedIn(): Task<Boolean> {
        val taskCompletionSource = TaskCompletionSource<Boolean>()
        var authStateListener: FirebaseAuth.AuthStateListener? = null

        authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user: FirebaseUser? = firebaseAuth.currentUser
            if (user != null) taskCompletionSource.setResult(true)
        }

        firebaseAuth.addAuthStateListener(authStateListener)

        taskCompletionSource.task.addOnCompleteListener {
            firebaseAuth.removeAuthStateListener(authStateListener)
        }

        return taskCompletionSource.task
    }

    fun getUserId(): String? = firebaseAuth.currentUser?.uid

    fun checkUserLoggedIn(): Task<Boolean> {
        val taskCompletionSource = TaskCompletionSource<Boolean>()
        var authStateListener: FirebaseAuth.AuthStateListener? = null

        authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user: FirebaseUser? = firebaseAuth.currentUser
            if (user != null) taskCompletionSource.setResult(true)
        }

        firebaseAuth.addAuthStateListener(authStateListener)

        taskCompletionSource.task.addOnCompleteListener {
            firebaseAuth.removeAuthStateListener(authStateListener)
        }

        return taskCompletionSource.task
    }
}