//[users](../../index.md)/[ru.surf.users.ui.screens.listUsers](index.md)/[ListUsersBody](-list-users-body.md)

# ListUsersBody

[androidJvm]\

@Composable

fun [ListUsersBody](-list-users-body.md)(search: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, items: LazyPagingItems&lt;[UserModel](../ru.surf.users.data.models/-user-model/index.md)&gt;, searchItems: LazyPagingItems&lt;[UserModel](../ru.surf.users.data.models/-user-model/index.md)&gt;, onActions: ([ListUsersActions](../ru.surf.users.ui.actions/-list-users-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})

Body page [ListUsersScreen](-list-users-screen.md)

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| search | state call query to api |
| items | list paging list LazyPagingItems |
| searchItems | searching list paging list LazyPagingItems |
| onActions | actions page |
