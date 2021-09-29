//[users](../../../index.md)/[ru.surf.users.services.dataService.impl](../index.md)/[UserModelDataService](index.md)

# UserModelDataService

[androidJvm]\
interface [UserModelDataService](index.md) : [IAppDatabase](../../../../../modules/core/core/ru.surf.core.interfaces/-i-app-database/index.md)

Service part for work with model [UserModel](../../ru.surf.users.data.models/-user-model/index.md)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |
| [clearUserModel](clear-user-model.md) | [androidJvm]<br>open suspend fun [clearUserModel](clear-user-model.md)()<br>Remove all models |
| [countUserModel](count-user-model.md) | [androidJvm]<br>open suspend fun [countUserModel](count-user-model.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Get count models |
| [getUserModel](get-user-model.md) | [androidJvm]<br>open fun [getUserModel](get-user-model.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;<br>Get Flow model |
| [insertUserModel](insert-user-model.md) | [androidJvm]<br>open suspend fun [insertUserModel](insert-user-model.md)(vararg models: [UserModel](../../ru.surf.users.data.models/-user-model/index.md))<br>Fun for insert models |
| [pagingListUserModel](paging-list-user-model.md) | [androidJvm]<br>open fun [pagingListUserModel](paging-list-user-model.md)(): [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;<br>Get [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) for paging list |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private val [dao](dao.md): [UserModelDao](../../ru.surf.users.data.dao/-user-model-dao/index.md)<br>Doa model [UserModel](../../ru.surf.users.data.models/-user-model/index.md) |
| [db](db.md) | [androidJvm]<br>abstract override val [db](db.md): [UsersDatabase](../../ru.surf.users.base/-users-database/index.md)<br>Base room db |

## Inheritors

| Name |
|---|
| [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md) |
