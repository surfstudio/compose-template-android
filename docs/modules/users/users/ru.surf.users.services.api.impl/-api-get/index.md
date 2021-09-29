//[users](../../../index.md)/[ru.surf.users.services.api.impl](../index.md)/[ApiGet](index.md)

# ApiGet

[androidJvm]\
interface [ApiGet](index.md)

The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [getListUsers](get-list-users.md) | [androidJvm]<br>@GET(value = "users")<br>abstract suspend fun [getListUsers](get-list-users.md)(@Query(value = "search")search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, @Query(value = "offset")offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, @[IntRange](https://developer.android.com/reference/kotlin/androidx/annotation/IntRange.html)(from = 1, to = 100)@Query(value = "limit")limit: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = ConstantsPaging.PAGE_LIMIT): Response&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[UserResponse](../../ru.surf.users.data.responses/-user-response/index.md)&gt;&gt;<br>Get list users |
| [updateUser](update-user.md) | [androidJvm]<br>@GET(value = "users/{id}")<br>abstract suspend fun [updateUser](update-user.md)(@Path(value = "id")id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): Response&lt;[UserResponse](../../ru.surf.users.data.responses/-user-response/index.md)&gt;<br>Update user model |

## Inheritors

| Name |
|---|
| [UsersApi](../../ru.surf.users.services.api/-users-api/index.md) |
