package com.roblesdotdev.core.data.auth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.roblesdotdev.core.domain.session.SessionInfo
import com.roblesdotdev.core.domain.session.SessionStorage

class FirebaseSessionStorage : SessionStorage {
    override suspend fun get(): SessionInfo? {
        return Firebase.auth.currentUser?.let { user ->
            SessionInfo(
                userId = user.uid
            )
        }
    }

    override suspend fun set(info: SessionInfo?) {
        if (info == null) {
            Firebase.auth.signOut()
        }
    }

}