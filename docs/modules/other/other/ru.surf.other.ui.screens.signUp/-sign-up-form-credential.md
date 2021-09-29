//[other](../../index.md)/[ru.surf.other.ui.screens.signUp](index.md)/[SignUpFormCredential](-sign-up-form-credential.md)

# SignUpFormCredential

[androidJvm]\

@Composable

fun [SignUpFormCredential](-sign-up-form-credential.md)(state: PagerState = rememberPagerState(pageCount = 0), loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, commonError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onActions: ([SignUpActions](../ru.surf.other.ui.actions/-sign-up-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, savedData: (email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { _, _ -&gt; })

Form page [SignUpBody](-sign-up-body.md)

#### Author

Vitaliy Zarubin

## Parameters

androidJvm

| | |
|---|---|
| state | page view state |
| loading | state call query to api |
| commonError | state error response |
| onActions | actions page |
| savedData | callback success result |
