//[users](../../../index.md)/[ru.surf.users.paging](../index.md)/[UsersRemoteMediator](index.md)

# UsersRemoteMediator

[androidJvm]\
class [UsersRemoteMediator](index.md)(apiService: [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md), dataService: [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md), preferences: [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md)) : [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt; 

Paging list with room cache [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.html)

#### Author

Vitaliy Zarubin

## See also

androidJvm

| | |
|---|---|
|  | <a href="https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator">RemoteMediator</a> |

## Parameters

androidJvm

| | |
|---|---|
| apiService | query service module |
| dataService | service room db |
| preferences | service shared preferences |

## Constructors

| | |
|---|---|
| [UsersRemoteMediator](-users-remote-mediator.md) | [androidJvm]<br>fun [UsersRemoteMediator](-users-remote-mediator.md)(apiService: [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md), dataService: [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md), preferences: [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md)<br>Static key for offset-limit paging |

## Functions

| Name | Summary |
|---|---|
| [initialize](initialize.md) | [androidJvm]<br>open suspend override fun [initialize](initialize.md)(): [RemoteMediator.InitializeAction](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.InitializeAction.html)<br>Timeout cache for refresh list at start |
| [load](load.md) | [androidJvm]<br>open suspend override fun [load](load.md)(loadType: [LoadType](https://developer.android.com/reference/kotlin/androidx/paging/LoadType.html), state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;): [RemoteMediator.MediatorResult](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.MediatorResult.html)<br>Base logic |

## Properties

| Name | Summary |
|---|---|
| [apiService](api-service.md) | [androidJvm]<br>private val [apiService](api-service.md): [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md) |
| [dataService](data-service.md) | [androidJvm]<br>private val [dataService](data-service.md): [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md) |
| [preferences](preferences.md) | [androidJvm]<br>private val [preferences](preferences.md): [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md) |
