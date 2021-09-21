package ru.surf.template.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.surf.core.base.CorePreferences
import ru.surf.template.base.TemplateDatabase
import ru.surf.template.data.preferences.TemplatePreferences
import ru.surf.template.services.api.TemplateApi
import ru.surf.template.services.dataService.TemplateDataService

@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    @Provides
    // @todo provide{ModuleName}Database
    // @todo {ModuleName}Database
    fun provideTemplateDatabase(application: Application): TemplateDatabase {
        return Room.databaseBuilder(
            application,
            TemplateDatabase::class.java,
            "${ModuleDefault::class.qualifiedName}.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    // @todo provide{ModuleName}DataService
    // @todo {ModuleName}Database
    // @todo {ModuleName}DataService
    fun provideTemplateDataService(db: TemplateDatabase) = TemplateDataService(db)

    @Provides
    // @todo provide{ModuleName}Preferences
    // @todo {ModuleName}Preferences
    fun provideTemplatePreferences(corePreferences: CorePreferences) = TemplatePreferences(corePreferences.p)

    @Provides
    // @todo provide{ModuleName}Api
    // @todo {ModuleName}Api
    fun provideTemplateApi(retrofit: Retrofit): TemplateApi = retrofit.create(TemplateApi::class.java)
}
