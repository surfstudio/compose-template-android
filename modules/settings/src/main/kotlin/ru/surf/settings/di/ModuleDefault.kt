/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.data.preferences.CorePreferences
import ru.surf.settings.data.preferences.SettingsPreferences

/**
 * Dagger Module base for module (settings)
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
    fun provideSettingsPreferences(corePreferences: CorePreferences) = SettingsPreferences(corePreferences.p)
}
