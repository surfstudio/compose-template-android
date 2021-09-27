/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.base.CorePreferences
import ru.surf.settings.data.preferences.SettingsPreferences

@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {
    @Provides
    fun provideSettingsPreferences(corePreferences: CorePreferences) = SettingsPreferences(corePreferences.p)
}
