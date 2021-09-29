//[core](../../../index.md)/[ru.surf.core.di](../index.md)/[ModuleNetwork](index.md)

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
| [provideCoreApi](provide-core-api.md) | [androidJvm]<br>@Provides<br>fun [provideCoreApi](provide-core-api.md)(retrofit: Retrofit): [CoreApi](../../ru.surf.core.services.api/-core-api/index.md)<br>HTTP API into a interface |
| [provideUsersApiService](provide-users-api-service.md) | [androidJvm]<br>@Provides<br>fun [provideUsersApiService](provide-users-api-service.md)(api: [CoreApi](../../ru.surf.core.services.api/-core-api/index.md)): [CoreApiService](../../ru.surf.core.services.apiService/-core-api-service/index.md)<br>HTTP query service |
