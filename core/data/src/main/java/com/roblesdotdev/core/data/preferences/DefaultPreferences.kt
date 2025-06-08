package com.roblesdotdev.core.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.roblesdotdev.core.domain.preferences.UserPreferences
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DefaultUserPreferences(
    private val dataStore: DataStore<Preferences>
) : UserPreferences {

    companion object {
        private val ONBOARDING_KEY = booleanPreferencesKey(UserPreferences.KEY_COMPLETE_ONBOARDING)
    }

    override suspend fun isCompleteOnboarding(): Boolean {
        return dataStore.data
            .map { userPreferences -> userPreferences[ONBOARDING_KEY] == true }
            .first()
    }

    override suspend fun completeOnboarding() {
        dataStore.edit { userPreferences -> userPreferences[ONBOARDING_KEY] = true }
    }

}