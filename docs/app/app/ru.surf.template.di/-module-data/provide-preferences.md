//[app](../../../index.md)/[ru.surf.template.di](../index.md)/[ModuleData](index.md)/[providePreferences](provide-preferences.md)

# providePreferences

[androidJvm]\

@Provides

@ElementsIntoSet

fun [providePreferences](provide-preferences.md)(core: [CorePreferences](../../../../modules/core/core/ru.surf.core.data.preferences/-core-preferences/index.md), other: [OtherPreferences](../../../../modules/other/other/ru.surf.other.data.preferences/-other-preferences/index.md), users: [UsersPreferences](../../../../modules/users/users/ru.surf.users.data.preferences/-users-preferences/index.md), settings: [SettingsPreferences](../../../../modules/settings/settings/ru.surf.settings.data.preferences/-settings-preferences/index.md)): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[IAppPreferences](../../../../modules/core/core/ru.surf.core.interfaces/-i-app-preferences/index.md)&gt;

List of preferences to clean up after logout

#### Return

list services preferences

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| core | service [CorePreferences](../../../../modules/core/core/ru.surf.core.data.preferences/-core-preferences/index.md) shared preferences from module core |
| other | service [OtherPreferences](../../../../modules/other/other/ru.surf.other.data.preferences/-other-preferences/index.md) shared preferences from module other |
| users | service [UsersPreferences](../../../../modules/users/users/ru.surf.users.data.preferences/-users-preferences/index.md) shared preferences from module users |
| settings | service [SettingsPreferences](../../../../modules/settings/settings/ru.surf.settings.data.preferences/-settings-preferences/index.md) shared preferences from module settings |
