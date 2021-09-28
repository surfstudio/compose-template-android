/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.core.services.api.CoreApi
import ru.surf.core.services.apiService.CoreApiService

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
    fun provideCoreApi(retrofit: Retrofit): CoreApi = retrofit.create(CoreApi::class.java)

    /**
     * HTTP query service
     */
    @Provides
    fun provideUsersApiService(api: CoreApi) = CoreApiService(api)
}
