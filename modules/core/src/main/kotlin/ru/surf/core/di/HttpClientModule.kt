/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
import ru.surf.core.utils.ConstantsApp.API_URL
import timber.log.Timber

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
                HttpLoggingInterceptor { message -> Timber.i(message) }.apply {
                    level = HttpLoggingInterceptor.Level.BODY
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
