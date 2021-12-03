/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.template.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import ru.surf.core.data.preferences.CorePreferences
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
     * @return list services room db
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
     * @return list services preferences
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
