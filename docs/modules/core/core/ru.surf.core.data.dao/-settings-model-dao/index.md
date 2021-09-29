//[core](../../../index.md)/[ru.surf.core.data.dao](../index.md)/[SettingsModelDao](index.md)

# SettingsModelDao

[androidJvm]\
interface [SettingsModelDao](index.md)

Dao for model [SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md)

#### Author

Vitaliy Zarubin

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>abstract suspend fun [clear](clear.md)() |
| [getModels](get-models.md) | [androidJvm]<br>abstract fun [getModels](get-models.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md)&gt;&gt; |
| [insertModels](insert-models.md) | [androidJvm]<br>abstract suspend fun [insertModels](insert-models.md)(vararg models: [SettingsModel](../../ru.surf.core.data.models/-settings-model/index.md)) |
