package com.roblesdotdev.core.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.roblesdotdev.core.data.auth.FakeSessionStorage
import com.roblesdotdev.core.data.preferences.DefaultUserPreferences
import com.roblesdotdev.core.domain.preferences.UserPreferences
import com.roblesdotdev.core.domain.session.SessionStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
   @Provides
   @Singleton
   fun provideDataStorePreferences(
       @ApplicationContext context: Context
   ): DataStore<Preferences> {
       return PreferenceDataStoreFactory.create {
           context.preferencesDataStoreFile("user_preferences")
       }
   }

    @Provides
    @Singleton
    fun provideUserPreferences(
        dataStore: DataStore<Preferences>
    ): UserPreferences {
        return DefaultUserPreferences(dataStore)
    }

    @Provides
    @Singleton
    fun provideSessionStorage(): SessionStorage {
        return FakeSessionStorage()
    }
}