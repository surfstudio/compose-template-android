//[users](../../../index.md)/[ru.surf.users.data.models](../index.md)/[UserModel](index.md)

# UserModel

[androidJvm]\
@Immutable

data class [UserModel](index.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IModel](../../../../../modules/core/core/ru.surf.core.interfaces/-i-model/index.md)

User model base for module

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [UserModel](-user-model.md) | [androidJvm]<br>fun [UserModel](-user-model.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>identifier user |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>user name fname + lname |
