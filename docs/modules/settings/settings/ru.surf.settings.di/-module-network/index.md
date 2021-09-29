//[settings](../../../index.md)/[ru.surf.settings.di](../index.md)/[ModuleNetwork](index.md)

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
| [provideSettingsApi](provide-settings-api.md) | [androidJvm]<br>@Provides<br>fun [provideSettingsApi](provide-settings-api.md)(retrofit: Retrofit): [SettingsApi](../../ru.surf.settings.services.api/-settings-api/index.md)<br>HTTP API into a interface |
| [provideSettingsApiService](provide-settings-api-service.md) | [androidJvm]<br>@Provides<br>fun [provideSettingsApiService](provide-settings-api-service.md)(api: [SettingsApi](../../ru.surf.settings.services.api/-settings-api/index.md)): [SettingsApiService](../../ru.surf.settings.services.apiService/-settings-api-service/index.md)<br>HTTP query service |
