//[users](../../../index.md)/[ru.surf.users.services.apiService.impl](../index.md)/[ApiServiceGet](index.md)

# ApiServiceGet

[androidJvm]\
interface [ApiServiceGet](index.md)

The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [getListUsers](get-list-users.md) | [androidJvm]<br>open suspend fun [getListUsers](get-list-users.md)(offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): ResponseResult&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;&gt;<br>Get list models [UserModel](../../ru.surf.users.data.models/-user-model/index.md) |
| [updateUser](update-user.md) | [androidJvm]<br>open suspend fun [updateUser](update-user.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ResponseResult&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;<br>Update view with model [UserModel](../../ru.surf.users.data.models/-user-model/index.md) |

## Properties

| Name | Summary |
|---|---|
| [api](api.md) | [androidJvm]<br>abstract val [api](api.md): [UsersApi](../../ru.surf.users.services.api/-users-api/index.md) |

## Inheritors

| Name |
|---|
| [UsersApiService](../../ru.surf.users.services.apiService/-users-api-service/index.md) |
