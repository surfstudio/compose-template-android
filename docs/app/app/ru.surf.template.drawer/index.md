//[app](../../index.md)/[ru.surf.template.drawer](index.md)

# Package ru.surf.template.drawer

[androidJvm]\
A package containing a menu and its components.

##  Menu

The package contains classes responsible for managing the menu and displaying it. Also event handling.

## Types

| Name | Summary |
|---|---|
| [AppDrawerActions](-app-drawer-actions/index.md) | [androidJvm]<br>sealed class [AppDrawerActions](-app-drawer-actions/index.md)<br>Application menu actions |

## Functions

| Name | Summary |
|---|---|
| [AppDrawer](-app-drawer.md) | [androidJvm]<br>@Composable<br>fun [AppDrawer](-app-drawer.md)(scaffoldState: ScaffoldState = rememberScaffoldState(), currentRoute: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UsersNav.MainNav.ListUsersNavScreen.route, backDispatcher: [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)? = null, onActions: ([AppDrawerActions](-app-drawer-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Application menu |
| [AppDrawerItem](-app-drawer-item.md) | [androidJvm]<br>@Composable<br>fun [AppDrawerItem](-app-drawer-item.md)(label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), icon: ImageVector, isSelected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Application menu item |
| [Preview](-preview.md) | [androidJvm]<br>@Preview(uiMode = 16, device = "id:pixel_4")<br>@Preview(uiMode = 32, device = "id:Nexus 6")<br>@Composable<br>private fun [Preview](-preview.md)() |
