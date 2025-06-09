package com.roblesdotdev.core.domain.util

sealed interface DataError : Error {
    enum class Network: DataError {
        NO_INTERNET,
        UNAUTHORIZED,
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        CONFLICT,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN,
    }

    enum class Local: DataError {
        DISK_FULL,
        UNKNOWN,
    }
}