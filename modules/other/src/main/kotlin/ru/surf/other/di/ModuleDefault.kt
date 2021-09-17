package ru.surf.other.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.surf.core.base.CorePreferences
import ru.surf.other.data.preferences.OtherPreferences
import ru.surf.other.services.api.OtherApi

@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    @Provides
    fun provideOtherPreferences(corePreferences: CorePreferences) = OtherPreferences(corePreferences.p)

    @Provides
    fun provideOtherApi(retrofit: Retrofit): OtherApi = retrofit.create(OtherApi::class.java)
}
