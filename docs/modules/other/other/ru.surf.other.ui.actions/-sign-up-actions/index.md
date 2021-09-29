//[other](../../../index.md)/[ru.surf.other.ui.actions](../index.md)/[SignUpActions](index.md)

# SignUpActions

[androidJvm]\
sealed class [SignUpActions](index.md)

Actions sealed class for screen [SignUpScreen](../../ru.surf.other.ui.screens.signUp/-sign-up-screen.md)

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [SignUpActions](-sign-up-actions.md) | [androidJvm]<br>protected fun [SignUpActions](-sign-up-actions.md)() |

## Types

| Name | Summary |
|---|---|
| [SignUp](-sign-up/index.md) | [androidJvm]<br>data class [SignUp](-sign-up/index.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), lname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneWork: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneHome: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), card: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cvc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bio: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [SignUpActions](index.md)<br>Action registration user |
| [SignUpValidate](-sign-up-validate/index.md) | [androidJvm]<br>data class [SignUpValidate](-sign-up-validate/index.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [SignUpActions](index.md)<br>Validate email in back-end side |

## Inheritors

| Name |
|---|
| [SignUpActions](-sign-up-validate/index.md) |
| [SignUpActions](-sign-up/index.md) |
