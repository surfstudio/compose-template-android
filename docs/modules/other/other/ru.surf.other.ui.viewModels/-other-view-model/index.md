//[other](../../../index.md)/[ru.surf.other.ui.viewModels](../index.md)/[OtherViewModel](index.md)

# OtherViewModel

[androidJvm]\
class [OtherViewModel](index.md)@Injectconstructor(apiService: [OtherApiService](../../ru.surf.other.services.apiService/-other-api-service/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

[ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) for module

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [OtherViewModel](-other-view-model.md) | [androidJvm]<br>@Inject<br>fun [OtherViewModel](-other-view-model.md)(apiService: [OtherApiService](../../ru.surf.other.services.apiService/-other-api-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [androidJvm]<br>fun [signIn](sign-in.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), success: (userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Query login user with callback if success |
| [signUp](sign-up.md) | [androidJvm]<br>fun [signUp](sign-up.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), lname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneWork: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneHome: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), card: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cvc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bio: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), success: (userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Query registration |
| [signUpValidate](sign-up-validate.md) | [androidJvm]<br>fun [signUpValidate](sign-up-validate.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Query validate user email for registration |
| [startQuery](start-query.md) | [androidJvm]<br>private fun [startQuery](start-query.md)()<br>Clear state before query |

## Properties

| Name | Summary |
|---|---|
| [_commonError](_common-error.md) | [androidJvm]<br>private val [_commonError](_common-error.md): MutableStateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;<br>MutableStateFlow for errors state |
| [_commonSuccess](_common-success.md) | [androidJvm]<br>private val [_commonSuccess](_common-success.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?&gt; |
| [_loading](_loading.md) | [androidJvm]<br>private val [_loading](_loading.md): MutableStateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>MutableStateFlow for loading state |
| [apiService](api-service.md) | [androidJvm]<br>private val [apiService](api-service.md): [OtherApiService](../../ru.surf.other.services.apiService/-other-api-service/index.md)<br>service http query |
| [commonError](common-error.md) | [androidJvm]<br>val [commonError](common-error.md): StateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;<br>StateFlow for [_commonError](_common-error.md) |
| [commonSuccess](common-success.md) | [androidJvm]<br>val [commonSuccess](common-success.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?&gt;<br>StateFlow for [_commonSuccess](_common-success.md) |
| [loading](loading.md) | [androidJvm]<br>val [loading](loading.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>StateFlow for [_loading](_loading.md) |
