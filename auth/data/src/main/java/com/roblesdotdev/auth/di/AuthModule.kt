package com.roblesdotdev.auth.di

import com.roblesdotdev.auth.data.EmailPatternValidator
import com.roblesdotdev.auth.data.InMemoryAuthRepository
import com.roblesdotdev.auth.domain.AuthRepository
import com.roblesdotdev.auth.domain.PatternValidator
import com.roblesdotdev.auth.domain.UserDataValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideEmailPatternValidator(): PatternValidator {
        return EmailPatternValidator
    }

    @Provides
    @Singleton
    fun provideUserDataValidator(
        patternValidator: PatternValidator
    ): UserDataValidator {
       return UserDataValidator(patternValidator = patternValidator)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository {
       return InMemoryAuthRepository()
    }
}