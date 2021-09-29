//[other](../../../index.md)/[ru.surf.other.di](../index.md)/[ModuleNetwork](index.md)

# ModuleNetwork

[androidJvm]\
@Module

object [ModuleNetwork](index.md)

Module Dagger responsible for api services

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [provideOtherApi](provide-other-api.md) | [androidJvm]<br>@Provides<br>fun [provideOtherApi](provide-other-api.md)(retrofit: Retrofit): [OtherApi](../../ru.surf.other.services.api/-other-api/index.md)<br>HTTP API into a interface |
| [provideOtherApiService](provide-other-api-service.md) | [androidJvm]<br>@Provides<br>fun [provideOtherApiService](provide-other-api-service.md)(api: [OtherApi](../../ru.surf.other.services.api/-other-api/index.md)): [OtherApiService](../../ru.surf.other.services.apiService/-other-api-service/index.md)<br>HTTP query service |
