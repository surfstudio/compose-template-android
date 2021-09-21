package ru.surf.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet
import retrofit2.Retrofit
import ru.surf.core.base.*
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.core.services.api.CoreApi
import ru.surf.core.services.apiService.CoreApiService
import ru.surf.core.services.dataService.CoreDataService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    @Provides
    fun provideCoreApi(retrofit: Retrofit): CoreApi = retrofit.create(CoreApi::class.java)

    @Provides
    fun provideUsersApiService(api: CoreApi) = CoreApiService(api)
}
