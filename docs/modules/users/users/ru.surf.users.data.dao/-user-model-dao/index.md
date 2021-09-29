//[users](../../../index.md)/[ru.surf.users.data.dao](../index.md)/[UserModelDao](index.md)

# UserModelDao

[androidJvm]\
interface [UserModelDao](index.md)

Dao for model [UserModel](../../ru.surf.users.data.models/-user-model/index.md)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>abstract suspend fun [clear](clear.md)() |
| [count](count.md) | [androidJvm]<br>abstract suspend fun [count](count.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getModel](get-model.md) | [androidJvm]<br>abstract fun [getModel](get-model.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt; |
| [insertModels](insert-models.md) | [androidJvm]<br>abstract suspend fun [insertModels](insert-models.md)(vararg models: [UserModel](../../ru.surf.users.data.models/-user-model/index.md)) |
| [pagingSource](paging-source.md) | [androidJvm]<br>abstract fun [pagingSource](paging-source.md)(): [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [UserModel](../../ru.surf.users.data.models/-user-model/index.md)&gt; |
