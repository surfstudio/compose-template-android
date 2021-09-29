//[app](../../index.md)/[ru.surf.template.drawer](index.md)/[AppDrawer](-app-drawer.md)

# AppDrawer

[androidJvm]\

@Composable

fun [AppDrawer](-app-drawer.md)(scaffoldState: ScaffoldState = rememberScaffoldState(), currentRoute: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UsersNav.MainNav.ListUsersNavScreen.route, backDispatcher: [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)? = null, onActions: ([AppDrawerActions](-app-drawer-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})

Application menu

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| scaffoldState | just rememberScaffoldState |
| currentRoute | string route navigation |
| backDispatcher | just [LocalBackPressedDispatcher](../../../modules/core/core/ru.surf.core.base/-local-back-pressed-dispatcher.md) |
| onActions | callback with [AppDrawerActions](-app-drawer-actions/index.md) |
