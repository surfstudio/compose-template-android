//[users](../../../index.md)/[ru.surf.users.services.api.impl](../index.md)/[ApiGet](index.md)/[getListUsers](get-list-users.md)

# getListUsers

[androidJvm]\

@GET(value = "users")

abstract suspend fun [getListUsers](get-list-users.md)(@Query(value = "search")search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, @Query(value = "offset")offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, @[IntRange](https://developer.android.com/reference/kotlin/androidx/annotation/IntRange.html)(from = 1, to = 100)@Query(value = "limit")limit: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = ConstantsPaging.PAGE_LIMIT): Response&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[UserResponse](../../ru.surf.users.data.responses/-user-response/index.md)&gt;&gt;

Get list users

## See also

androidJvm

| | |
|---|---|
|  | <a href="https://dev.mysql.com/doc/refman/8.0/en/select.html">SELECT Statement</a> |

## Parameters

androidJvm

| | |
|---|---|
| search | for find users by name |
| offset | mysql limit |
