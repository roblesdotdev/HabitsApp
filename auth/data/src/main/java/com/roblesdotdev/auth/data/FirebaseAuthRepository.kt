package com.roblesdotdev.auth.data

import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.roblesdotdev.auth.domain.AuthRepository
import com.roblesdotdev.core.domain.util.DataError
import com.roblesdotdev.core.domain.util.EmptyResult
import com.roblesdotdev.core.domain.util.Result
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository : AuthRepository {
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        return try {
            Firebase.auth.signInWithEmailAndPassword(
                email,
                password,
            ).await()
            Result.Success(Unit)
        } catch (e: FirebaseAuthException) {
            Result.Failure(DataError.Network.UNAUTHORIZED)
        } catch (e: FirebaseNetworkException) {
            Result.Failure(DataError.Network.NO_INTERNET)
        } catch (e: Exception) {
            Result.Failure(DataError.Network.UNKNOWN)
        }
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return try {
            Firebase.auth.createUserWithEmailAndPassword(
                email,
                password
            ).await()
            Result.Success(Unit)
        } catch (e: FirebaseAuthException) {
            when (e.errorCode) {
                "ERROR_EMAIL_ALREADY_IN_USE" -> Result.Failure(DataError.Network.CONFLICT)
                else -> Result.Failure(DataError.Network.UNKNOWN)
            }
        } catch (e: FirebaseNetworkException) {
            Result.Failure(DataError.Network.NO_INTERNET)
        } catch (e: Exception) {
            Result.Failure(DataError.Network.UNKNOWN)
        }
    }
}