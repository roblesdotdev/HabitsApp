package com.roblesdotdev.core.domain.session

data class SessionInfo(
    val refreshToken: String = "",
    val accessToken: String = "",
    val userId: String = "",
)