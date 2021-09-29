//[core](../../../index.md)/[ru.surf.core.data.dao](../index.md)/[SecurityModelDao](index.md)

# SecurityModelDao

[androidJvm]\
interface [SecurityModelDao](index.md)

Dao for model [SecurityModel](../../ru.surf.core.data.models/-security-model/index.md)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>abstract suspend fun [clear](clear.md)() |
| [count](count.md) | [androidJvm]<br>abstract fun [count](count.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getModel](get-model.md) | [androidJvm]<br>abstract fun [getModel](get-model.md)(): Flow&lt;[SecurityModel](../../ru.surf.core.data.models/-security-model/index.md)?&gt; |
| [insertModels](insert-models.md) | [androidJvm]<br>abstract suspend fun [insertModels](insert-models.md)(vararg models: [SecurityModel](../../ru.surf.core.data.models/-security-model/index.md)) |
