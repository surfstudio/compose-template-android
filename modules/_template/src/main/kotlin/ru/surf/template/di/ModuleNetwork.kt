/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.template.services.api.TemplateApi
import ru.surf.template.services.apiService.TemplateApiService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    @Provides
    // @todo provide{ModuleName}Api
    // @todo {ModuleName}Api
    fun provideTemplateApi(retrofit: Retrofit): TemplateApi = retrofit.create(TemplateApi::class.java)

    @Provides
    // @todo provide{ModuleName}ApiService
    // @todo {ModuleName}Api
    // @todo {ModuleName}ApiService
    fun provideTemplateApiService(api: TemplateApi) = TemplateApiService(api)
}
