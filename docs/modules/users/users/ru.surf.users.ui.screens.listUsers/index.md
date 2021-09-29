//[users](../../index.md)/[ru.surf.users.ui.screens.listUsers](index.md)

# Package ru.surf.users.ui.screens.listUsers

## Functions

| Name | Summary |
|---|---|
| [ListUserItem](-list-user-item.md) | [androidJvm]<br>@Composable<br>fun [ListUserItem](-list-user-item.md)(model: [UserModel](../ru.surf.users.data.models/-user-model/index.md), onActions: ([ListUsersActions](../ru.surf.users.ui.actions/-list-users-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Item list for page [ListUsersBody](-list-users-body.md) |
| [ListUsersBody](-list-users-body.md) | [androidJvm]<br>@Composable<br>fun [ListUsersBody](-list-users-body.md)(search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, items: LazyPagingItems&lt;[UserModel](../ru.surf.users.data.models/-user-model/index.md)&gt;, searchItems: LazyPagingItems&lt;[UserModel](../ru.surf.users.data.models/-user-model/index.md)&gt;, onActions: ([ListUsersActions](../ru.surf.users.ui.actions/-list-users-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Body page [ListUsersScreen](-list-users-screen.md) |
| [ListUsersScreen](-list-users-screen.md) | [androidJvm]<br>@Composable<br>fun [ListUsersScreen](-list-users-screen.md)(viewModel: [UsersViewModel](../ru.surf.users.ui.viewModels/-users-view-model/index.md), onActions: ([ListUsersActions](../ru.surf.users.ui.actions/-list-users-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Base page fun for initialization |
