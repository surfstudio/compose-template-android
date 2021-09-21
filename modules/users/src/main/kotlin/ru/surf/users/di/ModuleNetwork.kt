package ru.surf.users.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import retrofit2.Retrofit
import ru.surf.core.services.api.CoreApi
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    @Provides
    fun provideUsersApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)

    @Provides
    fun provideUsersApiService(api: UsersApi) = UsersApiService(api)
}
