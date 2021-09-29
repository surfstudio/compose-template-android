//[core](../../../index.md)/[ru.surf.core.services.dataService](../index.md)/[CoreDataService](index.md)

# CoreDataService

[androidJvm]\
class [CoreDataService](index.md)(db: [CoreDatabase](../../ru.surf.core.base/-core-database/index.md), dbSecurity: [CoreSecurityDatabase](../../ru.surf.core.base/-core-security-database/index.md)) : [SecurityModelDataService](../../ru.surf.core.services.dataService.impl/-security-model-data-service/index.md), [SettingsModelDataService](../../ru.surf.core.services.dataService.impl/-settings-model-data-service/index.md)

Base service module for work with db room

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [CoreDataService](-core-data-service.md) | [androidJvm]<br>fun [CoreDataService](-core-data-service.md)(db: [CoreDatabase](../../ru.surf.core.base/-core-database/index.md), dbSecurity: [CoreSecurityDatabase](../../ru.surf.core.base/-core-security-database/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |

## Properties

| Name | Summary |
|---|---|
| [db](db.md) | [androidJvm]<br>open override val [db](db.md): [CoreDatabase](../../ru.surf.core.base/-core-database/index.md)<br>Base room db |
| [dbSecurity](db-security.md) | [androidJvm]<br>open override val [dbSecurity](db-security.md): [CoreSecurityDatabase](../../ru.surf.core.base/-core-security-database/index.md)<br>Base room db |
