/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.other.services.api.OtherApi
import ru.surf.other.services.apiService.OtherApiService

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
    fun provideOtherApi(retrofit: Retrofit): OtherApi = retrofit.create(OtherApi::class.java)

    /**
     * HTTP query service
     */
    @Provides
    fun provideOtherApiService(api: OtherApi) = OtherApiService(api)
}
