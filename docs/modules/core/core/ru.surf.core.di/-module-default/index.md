//[core](../../../index.md)/[ru.surf.core.di](../index.md)/[ModuleDefault](index.md)

# ModuleDefault

[androidJvm]\
@Module

object [ModuleDefault](index.md)

Dagger Module base for module (core)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [provideAppDatabase](provide-app-database.md) | [androidJvm]<br>@Provides<br>fun [provideAppDatabase](provide-app-database.md)(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)): [CoreDatabase](../../ru.surf.core.base/-core-database/index.md)<br>A database that doesn't need migrations and encryption |
| [provideCoreSecurityDatabase](provide-core-security-database.md) | [androidJvm]<br>@Provides<br>fun [provideCoreSecurityDatabase](provide-core-security-database.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [CoreSecurityDatabase](../../ru.surf.core.base/-core-security-database/index.md)<br>Database with encryption and migrations |
| [provideSharedPreferences](provide-shared-preferences.md) | [androidJvm]<br>@Provides<br>fun [provideSharedPreferences](provide-shared-preferences.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [CorePreferences](../../ru.surf.core.data.preferences/-core-preferences/index.md)<br>Shared preferences service |
| [provideUsersDataService](provide-users-data-service.md) | [androidJvm]<br>@Provides<br>fun [provideUsersDataService](provide-users-data-service.md)(db: [CoreDatabase](../../ru.surf.core.base/-core-database/index.md), dbSecurity: [CoreSecurityDatabase](../../ru.surf.core.base/-core-security-database/index.md)): [CoreDataService](../../ru.surf.core.services.dataService/-core-data-service/index.md)<br>Database management service |

## Properties

| Name | Summary |
|---|---|
| [migrations](migrations.md) | [androidJvm]<br>private val [migrations](migrations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt;<br>List with migrations for the database |
| [password](password.md) | [androidJvm]<br>private const val [password](password.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Base encryption key |
