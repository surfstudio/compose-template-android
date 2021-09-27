/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import ru.surf.core.base.CorePreferences
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.core.interfaces.IAppPreferences
import ru.surf.core.services.dataService.CoreDataService
import ru.surf.other.data.preferences.OtherPreferences
import ru.surf.settings.data.preferences.SettingsPreferences
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.dataService.UsersDataService

/**
 * Dagger Module with modules services for clear cache
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(SingletonComponent::class)
object ModuleData {

    /**
     * List of db to clean up after logout
     *
     * @param core service [CoreDataService] room db from module core
     * @param users service [UsersDataService] room db from module users
     *
     * @author Vitaliy Zarubin
     */
    @Provides
    @ElementsIntoSet
    fun provideDataServices(
        core: CoreDataService,
        users: UsersDataService,
    ): Set<IAppDatabase> {
        return listOf(core, users).toSet()
    }

    /**
     * List of preferences to clean up after logout
     *
     * @param core service [CorePreferences] shared preferences from module core
     * @param other service [OtherPreferences] shared preferences from module other
     * @param users service [UsersPreferences] shared preferences from module users
     * @param settings service [SettingsPreferences] shared preferences from module settings
     *
     * @author Vitaliy Zarubin
     */
    @Provides
    @ElementsIntoSet
    fun providePreferences(
        core: CorePreferences,
        other: OtherPreferences,
        users: UsersPreferences,
        settings: SettingsPreferences,
    ): Set<IAppPreferences> {
        return listOf(core, other, users, settings).toSet()
    }
}
