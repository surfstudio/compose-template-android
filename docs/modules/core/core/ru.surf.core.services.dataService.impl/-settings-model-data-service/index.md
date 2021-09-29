//[core](../../../index.md)/[ru.surf.core.services.dataService.impl](../index.md)/[SettingsModelDataService](index.md)

# SettingsModelDataService

[androidJvm]\
interface [SettingsModelDataService](index.md) : [IAppDatabase](../../ru.surf.core.interfaces/-i-app-database/index.md)

Service part for work with model [SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |
| [clearSettingsModel](clear-settings-model.md) | [androidJvm]<br>open suspend fun [clearSettingsModel](clear-settings-model.md)()<br>Remove all models |
| [getSettingsModel](get-settings-model.md) | [androidJvm]<br>open suspend fun [getSettingsModel](get-settings-model.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md)&gt;&gt;<br>Get Flow model |
| [insertSettingsModel](insert-settings-model.md) | [androidJvm]<br>open suspend fun [insertSettingsModel](insert-settings-model.md)(vararg models: [SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md))<br>Fun for insert models |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private val [dao](dao.md): [SettingsModelDao](../../ru.surf.core.data.dao/-settings-model-dao/index.md)<br>Doa model [SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md) |
| [db](db.md) | [androidJvm]<br>abstract override val [db](db.md): [CoreDatabase](../../ru.surf.core.base/-core-database/index.md)<br>Base room db |

## Inheritors

| Name |
|---|
| [CoreDataService](../../ru.surf.core.services.dataService/-core-data-service/index.md) |
