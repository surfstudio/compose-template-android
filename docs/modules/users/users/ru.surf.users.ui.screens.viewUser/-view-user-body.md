//[users](../../index.md)/[ru.surf.users.ui.screens.viewUser](index.md)/[ViewUserBody](-view-user-body.md)

# ViewUserBody

[androidJvm]\

@Composable

fun [ViewUserBody](-view-user-body.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), model: [UserModel](../ru.surf.users.data.models/-user-model/index.md)?, loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, error404: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, onActions: ([ViewUserActions](../ru.surf.users.ui.actions/-view-user-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, backDispatcher: [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)? = null)

Body page [ViewUserScreen](-view-user-screen.md)

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| id | user identifier |
| model | data db room [UserModel](../ru.surf.users.data.models/-user-model/index.md) |
| loading | state call query to api |
| error404 | state if model not found |
| onActions | actions page |
| backDispatcher | dispatcher press back |
