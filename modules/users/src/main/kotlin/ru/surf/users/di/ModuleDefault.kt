package ru.surf.users.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.surf.core.base.CorePreferences
import ru.surf.users.base.AppDatabase
import ru.surf.users.data.preferences.AppPreferences
import ru.surf.users.services.api.ApiUsers

@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "${ModuleDefault::class.qualifiedName}.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAppPreferences(corePreferences: CorePreferences) = AppPreferences(corePreferences.p)

    @Provides
    fun provideApiUsers(retrofit: Retrofit): ApiUsers = retrofit.create(ApiUsers::class.java)
}
