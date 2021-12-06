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

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.surf.core.BuildConfig
import ru.surf.core.utils.ConstantsApp.API_URL
import ru.surfstudio.android.logger.Logger

/**
 * Dagger Module with Retrofit
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(SingletonComponent::class)
object HttpClientModule {

    /**
     * Builder of the [Json] instance provided by `Json { ... }` factory function.
     */
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = false
    }

    /**
     * Factory for [calls][Call], which can be used to send HTTP requests and read their responses.
     */
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor { message ->
                    Logger.d("OkHttp $message")
                }.apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.BASIC
                    }
                }
            )
            .addInterceptor {
                val original = it.request()
                val request = original.newBuilder().apply {
                    // headers
                }
                    .method(original.method, original.body)
                    .build()
                it.proceed(request)
            }
            .build()
    }

    /**
     * Retrofit adapts a Java interface to HTTP calls by using annotations on the declared methods to define how requests are made.
     */
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}
