package ru.surf.template.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.template.base.TemplateDatabase
import ru.surf.template.data.preferences.TemplatePreferences
import ru.surf.template.services.api.TemplateApi
import ru.surf.template.services.apiService.TemplateApiService
import ru.surf.template.services.dataService.TemplateDataService

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
