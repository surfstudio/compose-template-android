package ru.surf.settings.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.settings.services.api.SettingsApi
import ru.surf.settings.services.apiService.SettingsApiService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    @Provides
    fun provideSettingsApi(retrofit: Retrofit): SettingsApi = retrofit.create(SettingsApi::class.java)

    @Provides
    fun provideSettingsApiService(api: SettingsApi) = SettingsApiService(api)
}
