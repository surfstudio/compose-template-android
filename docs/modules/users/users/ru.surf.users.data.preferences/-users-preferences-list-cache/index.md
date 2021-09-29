//[users](../../../index.md)/[ru.surf.users.data.preferences](../index.md)/[UsersPreferencesListCache](index.md)

# UsersPreferencesListCache

[androidJvm]\
interface [UsersPreferencesListCache](index.md) : [IAppPreferences](../../../../../modules/core/core/ru.surf.core.interfaces/-i-app-preferences/index.md)

Lists service shared preference for module

#### Author

Vitaliy Zarubin

## Types

| Name | Summary |
|---|---|
| [KEYS](-k-e-y-s/index.md) | [androidJvm]<br>enum [KEYS](-k-e-y-s/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[UsersPreferencesListCache.KEYS](-k-e-y-s/index.md)&gt; <br>We put the keys in enum |

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |

## Properties

| Name | Summary |
|---|---|
| [lastUpdateListUsers](last-update-list-users.md) | [androidJvm]<br>open var [lastUpdateListUsers](last-update-list-users.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Saving list update data |
| [p](p.md) | [androidJvm]<br>abstract override val [p](p.md): [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)<br>Store private, primitive data in key-value pairs [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) |

## Inheritors

| Name |
|---|
| [UsersPreferences](../-users-preferences/index.md) |
