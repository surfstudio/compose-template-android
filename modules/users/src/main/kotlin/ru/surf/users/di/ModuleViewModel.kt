package ru.surf.users.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.surf.users.base.AppDatabase
import ru.surf.users.base.AppPreferences
import ru.surf.users.services.api.ApiUsers
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    fun provideUsersDataService(db: AppDatabase, preferences: AppPreferences) = UsersDataService(db, preferences)

    @Provides
    fun provideUsersApiService(api: ApiUsers) = UsersApiService(api)
}
