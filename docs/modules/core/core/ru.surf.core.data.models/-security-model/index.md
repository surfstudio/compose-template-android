//[core](../../../index.md)/[ru.surf.core.data.models](../index.md)/[SecurityModel](index.md)

# SecurityModel

[androidJvm]\
@Immutable

data class [SecurityModel](index.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IModel](../../ru.surf.core.interfaces/-i-model/index.md)

Model saved with encryption for access

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [SecurityModel](-security-model.md) | [androidJvm]<br>fun [SecurityModel](-security-model.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "last", token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "") |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [token](token.md) | [androidJvm]<br>val [token](token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>singIn/Up string for authorization |
