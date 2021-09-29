//[users](../../../index.md)/[ru.surf.users.data.preferences](../index.md)/[UsersPreferencesBase](index.md)

# UsersPreferencesBase

[androidJvm]\
interface [UsersPreferencesBase](index.md) : [IAppPreferences](../../../../../modules/core/core/ru.surf.core.interfaces/-i-app-preferences/index.md)

Common service shared preference for module

#### Author

Vitaliy Zarubin

## Types

| Name | Summary |
|---|---|
| [KEYS](-k-e-y-s/index.md) | [androidJvm]<br>enum [KEYS](-k-e-y-s/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[UsersPreferencesBase.KEYS](-k-e-y-s/index.md)&gt; <br>We put the keys in enum |

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |

## Properties

| Name | Summary |
|---|---|
| [isStartPage](is-start-page.md) | [androidJvm]<br>open var [isStartPage](is-start-page.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>An example of a possible variable |
| [p](p.md) | [androidJvm]<br>abstract override val [p](p.md): [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)<br>Store private, primitive data in key-value pairs [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) |

## Inheritors

| Name |
|---|
| [UsersPreferences](../-users-preferences/index.md) |
