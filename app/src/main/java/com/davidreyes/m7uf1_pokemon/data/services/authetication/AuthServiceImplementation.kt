package com.davidreyes.m7uf1_pokemon.data.services.authetication

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthServiceImplementation @Inject constructor(
    private val authService: AuthService
) {
    private val logTag: String = "AuthServiceImplementation"

    fun isUserLoggedIn(): Boolean = authService.isUserLoggedIn()

    suspend fun sendPasswordResetEmail(email: String) = withContext(Dispatchers.IO) {
        try {
            authService.sendPasswordResetEmail(email).await()
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw AuthServiceException("Error while trying to send password reset email.")
        }
    }

    fun observeUserLoggedIn(): Task<Boolean> = authService.observeUserLoggedIn()

    fun checkUserLoggedIn(): Task<Boolean> = authService.checkUserLoggedIn()

    suspend fun signIn(email: String, password: String): FirebaseUser {
        val errorMessage: String = "Error while trying to sign in."

        try {
            val response: Task<AuthResult> = authService.signIn(email, password)
            val user: FirebaseUser? = response.await().user

            return user ?: throw AuthServiceException(errorMessage)
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw AuthServiceException(errorMessage)
        }
    }

    suspend fun signUp(email: String, password: String): FirebaseUser {
        val errorMessage: String = "Error while trying to sign up."

        try {
            val response: Task<AuthResult> = authService.signUp(email, password)
            val user: FirebaseUser? = response.await().user

            return user ?: throw AuthServiceException(errorMessage)
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw AuthServiceException(errorMessage)
        }
    }

    fun logOut() = authService.logOut()
}