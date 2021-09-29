//[core](../../../index.md)/[ru.surf.core.di](../index.md)/[HttpClientModule](index.md)

# HttpClientModule

[androidJvm]\
@Module

object [HttpClientModule](index.md)

Dagger Module with Retrofit

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [provideOkHttpClient](provide-ok-http-client.md) | [androidJvm]<br>@Provides<br>fun [provideOkHttpClient](provide-ok-http-client.md)(): OkHttpClient<br>Factory for calls, which can be used to send HTTP requests and read their responses. |
| [provideRetrofit](provide-retrofit.md) | [androidJvm]<br>@Provides<br>fun [provideRetrofit](provide-retrofit.md)(okHttpClient: OkHttpClient): Retrofit<br>Retrofit adapts a Java interface to HTTP calls by using annotations on the declared methods to define how requests are made. |

## Properties

| Name | Summary |
|---|---|
| [json](json.md) | [androidJvm]<br>private val [json](json.md): Json<br>Builder of the Json instance provided by Json { ... } factory function. |
