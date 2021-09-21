package ru.surf.other.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.other.services.api.OtherApi
import ru.surf.other.services.apiService.OtherApiService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    @Provides
    fun provideOtherApi(retrofit: Retrofit): OtherApi = retrofit.create(OtherApi::class.java)

    @Provides
    fun provideOtherApiService(api: OtherApi) = OtherApiService(api)
}
