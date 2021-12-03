/**
 * Copyright 2021 Surf LLC
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
package ru.surf.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import ru.surf.core.base.*
import ru.surf.core.data.migrations.Migrations_1_2
import ru.surf.core.data.preferences.CorePreferences
import ru.surf.core.services.dataService.CoreDataService

/**
 * Dagger Module base for module (core)
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    /**
     * Base encryption key
     */
    private const val password = "iyQtXqqG03I6UP1cHAqJ"

    /**
     * List with migrations for the database
     */
    private val migrations = listOf(
        Migrations_1_2
    )

    /**
     * Database with encryption and migrations
     */
    @Provides
    @CoreDatabaseSecurityQualifier
    fun provideCoreSecurityDatabase(@ApplicationContext context: Context): CoreSecurityDatabase {

        val passphrase = SQLiteDatabase.getBytes(password.toCharArray())
        val factory = SupportFactory(passphrase)
        val builder = Room
            .databaseBuilder(
                context,
                CoreSecurityDatabase::class.java,
                "${ModuleDefault::class.qualifiedName}.security.db"
            )

        migrations.forEach {
            builder.addMigrations(it)
        }

        return builder.fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .allowMainThreadQueries()
            .build()
    }

    /**
     * A database that doesn't need migrations and encryption
     */
    @Provides
    @CoreDatabaseQualifier
    fun provideAppDatabase(application: Application): CoreDatabase {
        return Room.databaseBuilder(application, CoreDatabase::class.java, "${ModuleDefault::class.qualifiedName}.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Database management service
     */
    @Provides
    fun provideUsersDataService(
        @CoreDatabaseQualifier db: CoreDatabase,
        @CoreDatabaseSecurityQualifier dbSecurity: CoreSecurityDatabase,
    ) = CoreDataService(db, dbSecurity)

    /**
     * Shared preferences service
     */
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): CorePreferences {
        return CorePreferences(context.getSharedPreferences(ModuleDefault::class.qualifiedName, Context.MODE_PRIVATE))
    }
}
