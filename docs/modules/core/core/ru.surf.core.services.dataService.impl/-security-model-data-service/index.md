//[core](../../../index.md)/[ru.surf.core.services.dataService.impl](../index.md)/[SecurityModelDataService](index.md)

# SecurityModelDataService

[androidJvm]\
interface [SecurityModelDataService](index.md) : [IAppDatabase](../../ru.surf.core.interfaces/-i-app-database/index.md)

Service part for work with model [SecurityModel](../../ru.surf.core.data.models/-security-model/index.md)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |
| [clearSecurityModel](clear-security-model.md) | [androidJvm]<br>open suspend fun [clearSecurityModel](clear-security-model.md)()<br>Remove all models |
| [getSecurityModel](get-security-model.md) | [androidJvm]<br>open fun [getSecurityModel](get-security-model.md)(): Flow&lt;[SecurityModel](../../ru.surf.core.data.models/-security-model/index.md)?&gt;<br>Get Flow model |
| [insertSecurityModel](insert-security-model.md) | [androidJvm]<br>open suspend fun [insertSecurityModel](insert-security-model.md)(vararg models: [SecurityModel](../../ru.surf.core.data.models/-security-model/index.md))<br>Fun for insert models |
| [isLogin](is-login.md) | [androidJvm]<br>open fun [isLogin](is-login.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Check user is login |

## Properties

| Name | Summary |
|---|---|
| [dao](dao.md) | [androidJvm]<br>private val [dao](dao.md): [SecurityModelDao](../../ru.surf.core.data.dao/-security-model-dao/index.md)<br>Doa model [SecurityModel](../../ru.surf.core.data.models/-security-model/index.md) |
| [dbSecurity](db-security.md) | [androidJvm]<br>abstract val [dbSecurity](db-security.md): [CoreSecurityDatabase](../../ru.surf.core.base/-core-security-database/index.md)<br>Base room db |

## Inheritors

| Name |
|---|
| [CoreDataService](../../ru.surf.core.services.dataService/-core-data-service/index.md) |
