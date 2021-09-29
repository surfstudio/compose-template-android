//[other](../../../index.md)/[ru.surf.other.services.apiService.impl](../index.md)/[ApiServicePost](index.md)/[signUp](sign-up.md)

# signUp

[androidJvm]\
open suspend fun [signUp](sign-up.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), lname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneWork: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneHome: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), card: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cvc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bio: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): ResponseResult&lt;[SignUpResponse](../../ru.surf.other.data.responses/-sign-up-response/index.md)&gt;

Query registration

#### Return

response for get userId and token

## Parameters

androidJvm

| | |
|---|---|
| email | login email user |
| pass | just password |
| fname | string name user |
| lname | string surname user |
| phoneWork | string phone from work |
| phoneHome | string phone form home |
| card | string format ####-####-####-#### |
| cvc | string format ### |
| bio | text about user |
