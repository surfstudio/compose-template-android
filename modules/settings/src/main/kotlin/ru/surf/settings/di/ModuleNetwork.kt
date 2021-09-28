/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.settings.services.api.SettingsApi
import ru.surf.settings.services.apiService.SettingsApiService

/**
 * Module Dagger responsible for api services
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    /**
     * HTTP API into a interface
     */
    @Provides
    fun provideSettingsApi(retrofit: Retrofit): SettingsApi = retrofit.create(SettingsApi::class.java)

    /**
     * HTTP query service
     */
    @Provides
    fun provideSettingsApiService(api: SettingsApi) = SettingsApiService(api)
}
