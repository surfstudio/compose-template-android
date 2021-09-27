/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.base.CorePreferences
import ru.surf.other.data.preferences.OtherPreferences

@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    @Provides
    fun provideOtherPreferences(corePreferences: CorePreferences) = OtherPreferences(corePreferences.p)
}
