//[core](../../../index.md)/[ru.surf.core.services.apiService.impl](../index.md)/[ApiServiceGet](index.md)

# ApiServiceGet

[androidJvm]\
interface [ApiServiceGet](index.md)

The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [getListSettings](get-list-settings.md) | [androidJvm]<br>open suspend fun [getListSettings](get-list-settings.md)(): ResponseResult&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md)&gt;&gt;<br>Get list settings from back-end |

## Properties

| Name | Summary |
|---|---|
| [api](api.md) | [androidJvm]<br>abstract val [api](api.md): [CoreApi](../../ru.surf.core.services.api/-core-api/index.md) |

## Inheritors

| Name |
|---|
| [CoreApiService](../../ru.surf.core.services.apiService/-core-api-service/index.md) |
