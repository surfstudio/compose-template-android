//[core](../../../index.md)/[ru.surf.core.services.api.impl](../index.md)/[ApiGet](index.md)

# ApiGet

[androidJvm]\
interface [ApiGet](index.md)

The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [getListSettings](get-list-settings.md) | [androidJvm]<br>@GET(value = "settings")<br>abstract suspend fun [getListSettings](get-list-settings.md)(): Response&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SettingsResponse](../../ru.surf.core.data.responses/-settings-response/index.md)&gt;&gt; |

## Inheritors

| Name |
|---|
| [CoreApi](../../ru.surf.core.services.api/-core-api/index.md) |
