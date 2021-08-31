package ru.surf.users.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.surf.users.base.AppDatabase
import ru.surf.users.base.preferences.AppPreferences

@Module
@InstallIn(SingletonComponent::class)
object ModuleSingleton {

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "template.users.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): AppPreferences {
        return AppPreferences(context.getSharedPreferences("ru.surf.users.app.preferences", Context.MODE_PRIVATE))
    }
}
