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

@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    @Provides
    fun provideCoreApi(retrofit: Retrofit): CoreApi = retrofit.create(CoreApi::class.java)

    @Provides
    fun provideUsersApiService(api: CoreApi) = CoreApiService(api)
}
