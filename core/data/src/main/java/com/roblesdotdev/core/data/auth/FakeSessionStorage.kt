package com.roblesdotdev.core.data.auth

import com.roblesdotdev.core.domain.session.SessionInfo
import com.roblesdotdev.core.domain.session.SessionStorage

class FakeSessionStorage(
) : SessionStorage {
    private var fakeSessionInfo: SessionInfo? = null
    override suspend fun get(): SessionInfo? {
        return fakeSessionInfo
    }

    override suspend fun set(info: SessionInfo?) {
        fakeSessionInfo = info
    }

}