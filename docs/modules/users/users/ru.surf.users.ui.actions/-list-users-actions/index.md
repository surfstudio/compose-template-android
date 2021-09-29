//[users](../../../index.md)/[ru.surf.users.ui.actions](../index.md)/[ListUsersActions](index.md)

# ListUsersActions

[androidJvm]\
sealed class [ListUsersActions](index.md)

Actions sealed class for screen [ListUsersScreen](../../ru.surf.users.ui.screens.listUsers/-list-users-screen.md)

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [ListUsersActions](-list-users-actions.md) | [androidJvm]<br>protected fun [ListUsersActions](-list-users-actions.md)() |

## Types

| Name | Summary |
|---|---|
| [OpenMenu](-open-menu/index.md) | [androidJvm]<br>object [OpenMenu](-open-menu/index.md) : [ListUsersActions](index.md)<br>Open main menu |
| [Search](-search/index.md) | [androidJvm]<br>class [Search](-search/index.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [ListUsersActions](index.md)<br>Find models by name |
| [ToViewUser](-to-view-user/index.md) | [androidJvm]<br>class [ToViewUser](-to-view-user/index.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ListUsersActions](index.md)<br>Open page view user |

## Inheritors

| Name |
|---|
| [ListUsersActions](-open-menu/index.md) |
| [ListUsersActions](-search/index.md) |
| [ListUsersActions](-to-view-user/index.md) |
