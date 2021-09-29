//[app](../../../index.md)/[ru.surf.template.di](../index.md)/[ModuleData](index.md)

# ModuleData

[androidJvm]\
@Module

object [ModuleData](index.md)

Dagger Module with modules services for clear cache

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [provideDataServices](provide-data-services.md) | [androidJvm]<br>@Provides<br>@ElementsIntoSet<br>fun [provideDataServices](provide-data-services.md)(core: [CoreDataService](../../../../modules/core/core/ru.surf.core.services.dataService/-core-data-service/index.md), users: [UsersDataService](../../../../modules/users/users/ru.surf.users.services.dataService/-users-data-service/index.md)): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[IAppDatabase](../../../../modules/core/core/ru.surf.core.interfaces/-i-app-database/index.md)&gt;<br>List of db to clean up after logout |
| [providePreferences](provide-preferences.md) | [androidJvm]<br>@Provides<br>@ElementsIntoSet<br>fun [providePreferences](provide-preferences.md)(core: [CorePreferences](../../../../modules/core/core/ru.surf.core.data.preferences/-core-preferences/index.md), other: [OtherPreferences](../../../../modules/other/other/ru.surf.other.data.preferences/-other-preferences/index.md), users: [UsersPreferences](../../../../modules/users/users/ru.surf.users.data.preferences/-users-preferences/index.md), settings: [SettingsPreferences](../../../../modules/settings/settings/ru.surf.settings.data.preferences/-settings-preferences/index.md)): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[IAppPreferences](../../../../modules/core/core/ru.surf.core.interfaces/-i-app-preferences/index.md)&gt;<br>List of preferences to clean up after logout |
