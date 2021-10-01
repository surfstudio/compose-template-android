package ru.surf.core.tests

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
abstract class ApiAbstract(open val path: String = "api-response") {

    val mockWebServer = MockWebServer()

    @OptIn(ExperimentalSerializationApi::class)
    inline fun <reified T> api(): T {

        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }

        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(T::class.java)
    }

    private fun MockWebServer.enqueueResponse(fileName: String, code: Int) {
        javaClass.classLoader?.getResourceAsStream("$path/$fileName")?.source()?.buffer()
            ?.let {
                enqueue(
                    MockResponse()
                        .setResponseCode(code)
                        .setBody(it.readString(StandardCharsets.UTF_8))
                )
            } ?: throw RuntimeException("File '$path/$fileName' not found!")
    }

    fun <T> runBlockingApi(fileName: String, code: Int, block: suspend CoroutineScope.() -> T) {
        mockWebServer.enqueueResponse(fileName = fileName, code = code)
        runBlocking {
            block.invoke(this)
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
