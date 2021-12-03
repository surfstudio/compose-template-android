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
package ru.surf.users.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.UsersApiService

/**
 * Module Dagger responsible for api services
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(ViewModelComponent::class)
object ModuleNetwork {

    /**
     * HTTP API into a interface
     */
    @Provides
    fun provideUsersApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)

    /**
     * HTTP query service
     */
    @Provides
    fun provideUsersApiService(api: UsersApi) = UsersApiService(api)
}
