//[core](../../../index.md)/[ru.surf.core.base](../index.md)/[MainViewModel](index.md)

# MainViewModel

[androidJvm]\
class [MainViewModel](index.md)@Injectconstructor(apiService: [CoreApiService](../../ru.surf.core.services.apiService/-core-api-service/index.md), dataService: [CoreDataService](../../ru.surf.core.services.dataService/-core-data-service/index.md), dataServices: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppDatabase](../../ru.surf.core.interfaces/-i-app-database/index.md)&gt;, preferences: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppPreferences](../../ru.surf.core.interfaces/-i-app-preferences/index.md)&gt;) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

Main [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) for app

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [MainViewModel](-main-view-model.md) | [androidJvm]<br>@Inject<br>fun [MainViewModel](-main-view-model.md)(apiService: [CoreApiService](../../ru.surf.core.services.apiService/-core-api-service/index.md), dataService: [CoreDataService](../../ru.surf.core.services.dataService/-core-data-service/index.md), dataServices: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppDatabase](../../ru.surf.core.interfaces/-i-app-database/index.md)&gt;, preferences: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppPreferences](../../ru.surf.core.interfaces/-i-app-preferences/index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [login](login.md) | [androidJvm]<br>fun [login](login.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Update status user guest to member |
| [logout](logout.md) | [androidJvm]<br>fun [logout](logout.md)()<br>Logout user |
| [updateSettings](update-settings.md) | [androidJvm]<br>fun [updateSettings](update-settings.md)()<br>Update common for application settings |

## Properties

| Name | Summary |
|---|---|
| [_hasNetwork](_has-network.md) | [androidJvm]<br>private val [_hasNetwork](_has-network.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow for listen has network |
| [_isReady](_is-ready.md) | [androidJvm]<br>private val [_isReady](_is-ready.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow for start app and end splash |
| [_loading](_loading.md) | [androidJvm]<br>private val [_loading](_loading.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow for loading state |
| [apiService](api-service.md) | [androidJvm]<br>private val [apiService](api-service.md): [CoreApiService](../../ru.surf.core.services.apiService/-core-api-service/index.md)<br>service http query |
| [dataService](data-service.md) | [androidJvm]<br>private val [dataService](data-service.md): [CoreDataService](../../ru.surf.core.services.dataService/-core-data-service/index.md)<br>service db room |
| [dataServices](data-services.md) | [androidJvm]<br>private var [dataServices](data-services.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppDatabase](../../ru.surf.core.interfaces/-i-app-database/index.md)&gt;<br>group services db room |
| [hasNetwork](has-network.md) | [androidJvm]<br>val [hasNetwork](has-network.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_hasNetwork](_has-network.md) |
| [isLogin](is-login.md) | [androidJvm]<br>val [isLogin](is-login.md): Flow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>Flow for listen change status user |
| [isReady](is-ready.md) | [androidJvm]<br>val [isReady](is-ready.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_isReady](_is-ready.md) |
| [loading](loading.md) | [androidJvm]<br>val [loading](loading.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_loading](_loading.md) |
| [preferences](preferences.md) | [androidJvm]<br>private var [preferences](preferences.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppPreferences](../../ru.surf.core.interfaces/-i-app-preferences/index.md)&gt;<br>group services shared preference |
