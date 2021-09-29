//[core](../../../index.md)/[ru.surf.core.interfaces](../index.md)/[IAppDatabase](index.md)

# IAppDatabase

[androidJvm]\
interface [IAppDatabase](index.md)

Interface for services db root

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>abstract fun [clearCacheAfterLogout](clear-cache-after-logout.md)() |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>abstract val [db](db.md): [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html) |

## Inheritors

| Name |
|---|
| [SecurityModelDataService](../../ru.surf.core.services.dataService.impl/-security-model-data-service/index.md) |
| [SettingsModelDataService](../../ru.surf.core.services.dataService.impl/-settings-model-data-service/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [withTransaction](../../ru.surf.core.extension/with-transaction.md) | [androidJvm]<br>suspend fun &lt;[T](../../ru.surf.core.extension/with-transaction.md)&gt; [IAppDatabase](index.md).[withTransaction](../../ru.surf.core.extension/with-transaction.md)(body: suspend [T](../../ru.surf.core.extension/with-transaction.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Extensions for easy transaction |
