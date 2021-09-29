//[other](../../../index.md)/[ru.surf.other.services.apiService.impl](../index.md)/[ApiServicePost](index.md)

# ApiServicePost

[androidJvm]\
interface [ApiServicePost](index.md)

The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [signIn](sign-in.md) | [androidJvm]<br>open suspend fun [signIn](sign-in.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ResponseResult&lt;[SignInResponse](../../ru.surf.other.data.responses/-sign-in-response/index.md)&gt;<br>Query login user with callback if success. For example use random query with error response. |
| [signUp](sign-up.md) | [androidJvm]<br>open suspend fun [signUp](sign-up.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), lname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneWork: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneHome: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), card: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cvc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bio: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ResponseResult&lt;[SignUpResponse](../../ru.surf.other.data.responses/-sign-up-response/index.md)&gt;<br>Query registration |
| [signUpValidate](sign-up-validate.md) | [androidJvm]<br>open suspend fun [signUpValidate](sign-up-validate.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ResponseResult&lt;[SignUpValidateResponse](../../ru.surf.other.data.responses/-sign-up-validate-response/index.md)&gt;<br>Query validate user email for registration |

## Properties

| Name | Summary |
|---|---|
| [api](api.md) | [androidJvm]<br>abstract val [api](api.md): [OtherApi](../../ru.surf.other.services.api/-other-api/index.md) |

## Inheritors

| Name |
|---|
| [OtherApiService](../../ru.surf.other.services.apiService/-other-api-service/index.md) |
