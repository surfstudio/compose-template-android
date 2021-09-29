//[users](../../../index.md)/[ru.surf.users.services.apiService.impl](../index.md)/[ApiServiceGet](index.md)/[getListUsers](get-list-users.md)

# getListUsers

[androidJvm]\
open suspend fun [getListUsers](get-list-users.md)(offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): ResponseResult&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt;&gt;

Get list models [UserModel](../../ru.surf.users.data.models/-user-model/index.md)

## Parameters

androidJvm

| | |
|---|---|
| offset | mysql offset |
| search | find models by name |
