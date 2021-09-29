//[users](../../../index.md)/[ru.surf.users.data.responses](../index.md)/[UserResponse](index.md)

# UserResponse

[androidJvm]\
@Immutable

data class [UserResponse](index.md)(code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Response for [UserModel](../../ru.surf.users.data.models/-user-model/index.md)

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [UserResponse](-user-response.md) | [androidJvm]<br>fun [UserResponse](-user-response.md)(code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [code](code.md) | [androidJvm]<br>val [code](code.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>identifier user |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>user name fname + lname |

## Extensions

| Name | Summary |
|---|---|
| [toModel](../../ru.surf.users.data.mappers/to-model.md) | [androidJvm]<br>fun [UserResponse](index.md).[toModel](../../ru.surf.users.data.mappers/to-model.md)(): [UserModel](../../ru.surf.users.data.models/-user-model/index.md)<br>Extension for response [UserResponse](index.md) |
