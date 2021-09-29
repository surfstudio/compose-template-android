//[other](../../index.md)/[ru.surf.other.ui.screens.signUp](index.md)/[SignUpFormProfile](-sign-up-form-profile.md)

# SignUpFormProfile

[androidJvm]\

@Composable

fun [SignUpFormProfile](-sign-up-form-profile.md)(state: PagerState = rememberPagerState(pageCount = 0), loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, commonError: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onActions: ([SignUpActions](../ru.surf.other.ui.actions/-sign-up-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}, dataEmail: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "", dataPass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "")

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
| dataEmail | data email from first page after validate |
| dataPass | data password from first page after validate |
