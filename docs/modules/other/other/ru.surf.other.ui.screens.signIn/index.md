//[other](../../index.md)/[ru.surf.other.ui.screens.signIn](index.md)

# Package ru.surf.other.ui.screens.signIn

## Functions

| Name | Summary |
|---|---|
| [Preview](-preview.md) | [androidJvm]<br>@Preview(uiMode = 16, device = "id:pixel_4")<br>@Preview(uiMode = 32, device = "id:Nexus 6")<br>@Composable<br>private fun [Preview](-preview.md)() |
| [SignInBody](-sign-in-body.md) | [androidJvm]<br>@Composable<br>fun [SignInBody](-sign-in-body.md)(loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, commonError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onActions: ([SignInActions](../ru.surf.other.ui.actions/-sign-in-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, backDispatcher: [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)? = null)<br>Body page [SignInScreen](-sign-in-screen.md) |
| [SignInForm](-sign-in-form.md) | [androidJvm]<br>@Composable<br>fun [SignInForm](-sign-in-form.md)(loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, onActions: ([SignInActions](../ru.surf.other.ui.actions/-sign-in-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Form page [SignInBody](-sign-in-body.md) |
| [SignInScreen](-sign-in-screen.md) | [androidJvm]<br>@Composable<br>fun [SignInScreen](-sign-in-screen.md)(viewModel: [OtherViewModel](../ru.surf.other.ui.viewModels/-other-view-model/index.md), onActions: ([SignInActions](../ru.surf.other.ui.actions/-sign-in-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Base page fun for initialization |
