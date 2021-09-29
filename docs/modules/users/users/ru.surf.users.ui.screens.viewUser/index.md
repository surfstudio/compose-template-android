//[users](../../index.md)/[ru.surf.users.ui.screens.viewUser](index.md)

# Package ru.surf.users.ui.screens.viewUser

## Functions

| Name | Summary |
|---|---|
| [Preview](-preview.md) | [androidJvm]<br>@Preview(uiMode = 16, device = "id:pixel_4")<br>@Preview(uiMode = 32, device = "id:Nexus 6")<br>@Composable<br>private fun [Preview](-preview.md)() |
| [ViewUserBody](-view-user-body.md) | [androidJvm]<br>@Composable<br>fun [ViewUserBody](-view-user-body.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), model: [UserModel](../ru.surf.users.data.models/-user-model/index.md)?, loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, error404: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, onActions: ([ViewUserActions](../ru.surf.users.ui.actions/-view-user-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, backDispatcher: [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)? = null)<br>Body page [ViewUserScreen](-view-user-screen.md) |
| [ViewUserScreen](-view-user-screen.md) | [androidJvm]<br>@Composable<br>fun [ViewUserScreen](-view-user-screen.md)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), viewModel: [UsersViewModel](../ru.surf.users.ui.viewModels/-users-view-model/index.md), onActions: ([ViewUserActions](../ru.surf.users.ui.actions/-view-user-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Base page fun for initialization |
