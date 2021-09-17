package ru.surf.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.core.base.*
import ru.surf.core.services.api.CoreApi
import ru.surf.core.services.apiService.CoreApiService
import ru.surf.core.services.dataService.CoreDataService

@Module
@InstallIn(ViewModelComponent::class)
object ModuleServices {

    @Provides
    fun provideUsersDataService(
        @CoreDatabaseQualifier db: CoreDatabase,
        @CoreDatabaseSecurityQualifier dbSecurity: CoreSecurityDatabase,
        preferences: CorePreferences
    ) = CoreDataService(db, dbSecurity, preferences)

    @Provides
    fun provideCoreApi(retrofit: Retrofit): CoreApi = retrofit.create(CoreApi::class.java)

    @Provides
    fun provideUsersApiService(api: CoreApi) = CoreApiService(api)
}
