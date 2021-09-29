//[users](../../../index.md)/[ru.surf.users.paging](../index.md)/[UsersPageSource](index.md)

# UsersPageSource

[androidJvm]\
class [UsersPageSource](index.md)(search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, apiService: [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt; 

Paging list without room cache [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)

#### Author

Vitaliy Zarubin

## See also

androidJvm

| | |
|---|---|
|  | <a href="https://developer.android.com/reference/kotlin/androidx/paging/PagingSource">PagingSource</a> |

## Parameters

androidJvm

| | |
|---|---|
| search | string query to back-end |
| apiService | query service module |

## Constructors

| | |
|---|---|
| [UsersPageSource](-users-page-source.md) | [androidJvm]<br>fun [UsersPageSource](-users-page-source.md)(search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, apiService: [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getRefreshKey](get-refresh-key.md) | [androidJvm]<br>open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [load](load.md) | [androidJvm]<br>open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [apiService](api-service.md) | [androidJvm]<br>private val [apiService](api-service.md): [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md) |
| [search](search.md) | [androidJvm]<br>private val [search](search.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
