//[users](../../../index.md)/[ru.surf.users.di](../index.md)/[ModuleNetwork](index.md)

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
| [provideUsersApi](provide-users-api.md) | [androidJvm]<br>@Provides<br>fun [provideUsersApi](provide-users-api.md)(retrofit: Retrofit): [UsersApi](../../ru.surf.users.services.api/-users-api/index.md)<br>HTTP API into a interface |
| [provideUsersApiService](provide-users-api-service.md) | [androidJvm]<br>@Provides<br>fun [provideUsersApiService](provide-users-api-service.md)(api: [UsersApi](../../ru.surf.users.services.api/-users-api/index.md)): [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md)<br>HTTP query service |
