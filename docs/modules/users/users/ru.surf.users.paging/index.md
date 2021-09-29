//[users](../../index.md)/[ru.surf.users.paging](index.md)

# Package ru.surf.users.paging

## Types

| Name | Summary |
|---|---|
| [UsersPageSource](-users-page-source/index.md) | [androidJvm]<br>class [UsersPageSource](-users-page-source/index.md)(search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, apiService: [UsersApiService](../ru.surf.users.services.apiService/-users-api-service/index.md)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../ru.surf.users.data.models/-user-model/index.md)&gt; <br>Paging list without room cache [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) |
| [UsersRemoteMediator](-users-remote-mediator/index.md) | [androidJvm]<br>class [UsersRemoteMediator](-users-remote-mediator/index.md)(apiService: [UsersApiService](../ru.surf.users.services.apiService/-users-api-service/index.md), dataService: [UsersDataService](../ru.surf.users.services.dataService/-users-data-service/index.md), preferences: [UsersPreferences](../ru.surf.users.data.preferences/-users-preferences/index.md)) : [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../ru.surf.users.data.models/-user-model/index.md)&gt; <br>Paging list with room cache [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.html) |
