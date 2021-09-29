/**
 * Copyright 2021 Surf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.template.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.data.preferences.CorePreferences
import ru.surf.template.base.TemplateDatabase
import ru.surf.template.data.preferences.TemplatePreferences
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
}
