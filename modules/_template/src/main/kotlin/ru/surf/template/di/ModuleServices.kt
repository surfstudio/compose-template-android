package ru.surf.template.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.surf.template.base.TemplateDatabase
import ru.surf.template.data.preferences.TemplatePreferences
import ru.surf.template.services.api.TemplateApi
import ru.surf.template.services.apiService.TemplateApiService
import ru.surf.template.services.dataService.TemplateDataService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleServices {

    @Provides
    // @todo provide{ModuleName}DataService
    // @todo {ModuleName}Database
    // @todo {ModuleName}Preferences
    // @todo {ModuleName}DataService
    fun provideTemplateDataService(db: TemplateDatabase, preferences: TemplatePreferences) = TemplateDataService(db, preferences)

    @Provides
    // @todo provide{ModuleName}ApiService
    // @todo {ModuleName}Api
    // @todo {ModuleName}ApiService
    fun provideTemplateApiService(api: TemplateApi) = TemplateApiService(api)
}
