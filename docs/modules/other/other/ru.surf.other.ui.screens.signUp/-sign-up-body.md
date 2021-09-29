//[other](../../index.md)/[ru.surf.other.ui.screens.signUp](index.md)/[SignUpBody](-sign-up-body.md)

# SignUpBody

[androidJvm]\

@Composable

fun [SignUpBody](-sign-up-body.md)(loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, commonError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, commonSuccess: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, onActions: ([SignUpActions](../ru.surf.other.ui.actions/-sign-up-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, backDispatcher: [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)? = null)

Body page [SignUpScreen](-sign-up-screen.md)

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| loading | state call query to api |
| commonError | state error response |
| commonSuccess | state success validate email |
| onActions | actions page |
| backDispatcher | dispatcher press back |
