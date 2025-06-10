package com.roblesdotdev.auth.data

import com.roblesdotdev.auth.domain.AuthRepository
import com.roblesdotdev.core.domain.util.DataError
import com.roblesdotdev.core.domain.util.EmptyResult
import com.roblesdotdev.core.domain.util.Result
import com.roblesdotdev.core.domain.util.asEmptyResult
import kotlinx.coroutines.delay

class InMemoryAuthRepository : AuthRepository {
    private val users = mutableMapOf<String, String>()
    override suspend fun login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val storedPassword = users[email]
        val result = when {
            storedPassword == null -> Result.Failure(DataError.Network.UNAUTHORIZED)
            storedPassword != password -> Result.Failure(DataError.Network.UNAUTHORIZED)
            else -> Result.Success(Unit)
        }
        delay(500)
        return result.asEmptyResult()
    }

    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val result = when {
            users.containsKey(email) -> Result.Failure(DataError.Network.CONFLICT)
            else -> {
                users[email] = password
                Result.Success(Unit)
            }
        }
        delay(500)
        return result.asEmptyResult()
    }

}