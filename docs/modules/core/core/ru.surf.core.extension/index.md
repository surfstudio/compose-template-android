//[core](../../index.md)/[ru.surf.core.extension](index.md)

# Package ru.surf.core.extension

## Functions

| Name | Summary |
|---|---|
| [EmitByStatus](-emit-by-status.md) | [androidJvm]<br>@Composable<br>fun [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html).[EmitByStatus](-emit-by-status.md)(status: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), emit: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Listen status for enable [OnBackPressedCallback](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedCallback.html) |
| [parseColor](parse-color.md) | [androidJvm]<br>fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[parseColor](parse-color.md)(): Color<br>Parse string color to Color |
| [withTransaction](with-transaction.md) | [androidJvm]<br>suspend fun &lt;[T](with-transaction.md)&gt; [IAppDatabase](../ru.surf.core.interfaces/-i-app-database/index.md).[withTransaction](with-transaction.md)(body: suspend [T](with-transaction.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Extensions for easy transaction |
