//[other](../../../index.md)/[ru.surf.other.ui.viewModels](../index.md)/[OtherViewModel](index.md)/[signUp](sign-up.md)

# signUp

[androidJvm]\
fun [signUp](sign-up.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pass: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), lname: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneWork: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), phoneHome: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), card: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cvc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bio: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), success: (userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Query registration

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
| success | callback if success with data user identifier and token |
