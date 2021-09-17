package ru.surf.other.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.surf.other.services.api.OtherApi
import ru.surf.other.services.apiService.OtherApiService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleServices {
    @Provides
    fun provideOtherApiService(api: OtherApi) = OtherApiService(api)
}
