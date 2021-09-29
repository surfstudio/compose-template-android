//[settings](../../../index.md)/[ru.surf.settings.ui.viewModels](../index.md)/[SettingsViewModel](index.md)

# SettingsViewModel

[androidJvm]\
class [SettingsViewModel](index.md)@Injectconstructor(apiService: [SettingsApiService](../../ru.surf.settings.services.apiService/-settings-api-service/index.md), preferences: [SettingsPreferences](../../ru.surf.settings.data.preferences/-settings-preferences/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

[ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) for module

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [SettingsViewModel](-settings-view-model.md) | [androidJvm]<br>@Inject<br>fun [SettingsViewModel](-settings-view-model.md)(apiService: [SettingsApiService](../../ru.surf.settings.services.apiService/-settings-api-service/index.md), preferences: [SettingsPreferences](../../ru.surf.settings.data.preferences/-settings-preferences/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [updateSettings](update-settings.md) | [androidJvm]<br>fun [updateSettings](update-settings.md)()<br>Function stub as an example of how it works |

## Properties

| Name | Summary |
|---|---|
| [_loading](_loading.md) | [androidJvm]<br>private val [_loading](_loading.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow for loading state |
| [apiService](api-service.md) | [androidJvm]<br>private val [apiService](api-service.md): [SettingsApiService](../../ru.surf.settings.services.apiService/-settings-api-service/index.md)<br>service http query |
| [loading](loading.md) | [androidJvm]<br>val [loading](loading.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_loading](_loading.md) |
| [preferences](preferences.md) | [androidJvm]<br>private val [preferences](preferences.md): [SettingsPreferences](../../ru.surf.settings.data.preferences/-settings-preferences/index.md)<br>service shared preference |
