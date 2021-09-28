/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.data.preferences.CorePreferences
import ru.surf.other.data.preferences.OtherPreferences

/**
 * Dagger Module base for module (other)
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    /**
     * Shared preferences service
     */
    @Provides
    fun provideOtherPreferences(corePreferences: CorePreferences) = OtherPreferences(corePreferences.p)
}
