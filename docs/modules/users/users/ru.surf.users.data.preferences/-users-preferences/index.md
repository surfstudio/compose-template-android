//[users](../../../index.md)/[ru.surf.users.data.preferences](../index.md)/[UsersPreferences](index.md)

# UsersPreferences

[androidJvm]\
class [UsersPreferences](index.md)(p: [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)) : [UsersPreferencesBase](../-users-preferences-base/index.md), [UsersPreferencesListCache](../-users-preferences-list-cache/index.md)

Base service shared preference module

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [UsersPreferences](-users-preferences.md) | [androidJvm]<br>fun [UsersPreferences](-users-preferences.md)(p: [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)) |

## Functions

| Name | Summary |
|---|---|
| [clearCacheAfterLogout](clear-cache-after-logout.md) | [androidJvm]<br>open override fun [clearCacheAfterLogout](clear-cache-after-logout.md)()<br>Performed when the user logs out |

## Properties

| Name | Summary |
|---|---|
| [p](p.md) | [androidJvm]<br>open override val [p](p.md): [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)<br>Store private, primitive data in key-value pairs [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) |
