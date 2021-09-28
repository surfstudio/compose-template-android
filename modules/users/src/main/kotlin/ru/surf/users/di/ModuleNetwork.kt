/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.UsersApiService

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
    fun provideUsersApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)

    /**
     * HTTP query service
     */
    @Provides
    fun provideUsersApiService(api: UsersApi) = UsersApiService(api)
}
