//[core](../../index.md)/[ru.surf.core.forms.validate](index.md)

# Package ru.surf.core.forms.validate

## Types

| Name | Summary |
|---|---|
| [PasswordStateValidateRequired](-password-state-validate-required/index.md) | [androidJvm]<br>class [PasswordStateValidateRequired](-password-state-validate-required/index.md) : FormFieldState<br>Validator for password |
| [StateValidateRequired](-state-validate-required/index.md) | [androidJvm]<br>class [StateValidateRequired](-state-validate-required/index.md) : FormFieldState<br>Validator if required |

## Functions

| Name | Summary |
|---|---|
| [getErrorIsLong](get-error-is-long.md) | [androidJvm]<br>private fun [getErrorIsLong](get-error-is-long.md)(target: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Validate length password for [PasswordStateValidateRequired](-password-state-validate-required/index.md) |
| [getErrorIsNotMatches](get-error-is-not-matches.md) | [androidJvm]<br>private fun [getErrorIsNotMatches](get-error-is-not-matches.md)(target: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Check password by regex [PasswordStateValidateRequired](-password-state-validate-required/index.md) |
| [getErrorIsSmall](get-error-is-small.md) | [androidJvm]<br>private fun [getErrorIsSmall](get-error-is-small.md)(target: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Validate length password for [PasswordStateValidateRequired](-password-state-validate-required/index.md) |

## Properties

| Name | Summary |
|---|---|
| [PASSWORD_VALIDATION_REGEX](-p-a-s-s-w-o-r-d_-v-a-l-i-d-a-t-i-o-n_-r-e-g-e-x.md) | [androidJvm]<br>private const val [PASSWORD_VALIDATION_REGEX](-p-a-s-s-w-o-r-d_-v-a-l-i-d-a-t-i-o-n_-r-e-g-e-x.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Regex check password |
