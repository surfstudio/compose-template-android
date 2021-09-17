package ru.surf.users.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleServices {

    @Provides
    fun provideUsersDataService(db: UsersDatabase, preferences: UsersPreferences) = UsersDataService(db, preferences)

    @Provides
    fun provideUsersApiService(api: UsersApi) = UsersApiService(api)
}
