//[users](../../../index.md)/[ru.surf.users.di](../index.md)/[ModuleDefault](index.md)

# ModuleDefault

[androidJvm]\
@Module

object [ModuleDefault](index.md)

Dagger Module base for module (users)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [provideUsersDatabase](provide-users-database.md) | [androidJvm]<br>@Provides<br>fun [provideUsersDatabase](provide-users-database.md)(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)): [UsersDatabase](../../ru.surf.users.base/-users-database/index.md)<br>A database that doesn't need migrations and encryption |
| [provideUsersDataService](provide-users-data-service.md) | [androidJvm]<br>@Provides<br>fun [provideUsersDataService](provide-users-data-service.md)(db: [UsersDatabase](../../ru.surf.users.base/-users-database/index.md)): [UsersDataService](../../ru.surf.users.services.dataService/-users-data-service/index.md)<br>Database management service |
| [provideUsersPreferences](provide-users-preferences.md) | [androidJvm]<br>@Provides<br>fun [provideUsersPreferences](provide-users-preferences.md)(corePreferences: [CorePreferences](../../../../../modules/core/core/ru.surf.core.data.preferences/-core-preferences/index.md)): [UsersPreferences](../../ru.surf.users.data.preferences/-users-preferences/index.md)<br>Shared preferences service |
