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
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.dataService.UsersDataService

@Module
@InstallIn(SingletonComponent::class)
object ModuleData {

    /**
     * List of db to clean up after logout
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
     */
    @Provides
    @ElementsIntoSet
    fun providePreferences(
        core: CorePreferences,
        other: OtherPreferences,
        users: UsersPreferences,
    ): Set<IAppPreferences> {
        return listOf(core, other, users).toSet()
    }
}
