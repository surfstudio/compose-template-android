//[users](../../../index.md)/[ru.surf.users.ui.viewModels](../index.md)/[UsersViewModel](index.md)

# UsersViewModel

[androidJvm]\
class [UsersViewModel](index.md)@Injectconstructor(apiService: [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md), dataService: [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md), preferences: [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

[ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) for module

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [UsersViewModel](-users-view-model.md) | [androidJvm]<br>@Inject<br>fun [UsersViewModel](-users-view-model.md)(apiService: [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md), dataService: [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md), preferences: [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getUser](get-user.md) | [androidJvm]<br>fun [getUser](get-user.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;<br>Flow room for view page |
| [search](search.md) | [androidJvm]<br>fun [search](search.md)(search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [updateUser](update-user.md) | [androidJvm]<br>fun [updateUser](update-user.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Update view with model [UserModel](../../ru.surf.users.data.models/-user-model/index.md) |

## Properties

| Name | Summary |
|---|---|
| [_error404](_error404.md) | [androidJvm]<br>private val [_error404](_error404.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow state 404 response |
| [_loading](_loading.md) | [androidJvm]<br>private val [_loading](_loading.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow for loading state |
| [_search](_search.md) | [androidJvm]<br>private val [_search](_search.md): MutableStateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;<br>MutableStateFlow for search query |
| [apiService](api-service.md) | [androidJvm]<br>private val [apiService](api-service.md): [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md)<br>service http query |
| [dataService](data-service.md) | [androidJvm]<br>private val [dataService](data-service.md): [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md)<br>service db room |
| [error404](error404.md) | [androidJvm]<br>val [error404](error404.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_error404](_error404.md) |
| [listUsers](list-users.md) | [androidJvm]<br>val [listUsers](list-users.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;&gt;<br>List with paging [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator.html) |
| [loading](loading.md) | [androidJvm]<br>val [loading](loading.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_loading](_loading.md) |
| [preferences](preferences.md) | [androidJvm]<br>private val [preferences](preferences.md): [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md)<br>service shared preference |
| [search](search.md) | [androidJvm]<br>val [search](search.md): StateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;<br>StateFlow for [_search](_search.md) |
| [searchListUsers](search-list-users.md) | [androidJvm]<br>val [searchListUsers](search-list-users.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;&gt;<br>List with paging [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) |
