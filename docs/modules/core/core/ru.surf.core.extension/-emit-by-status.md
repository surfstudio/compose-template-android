//[core](../../index.md)/[ru.surf.core.extension](index.md)/[EmitByStatus](-emit-by-status.md)

# EmitByStatus

[androidJvm]\

@Composable

fun [OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html).[EmitByStatus](-emit-by-status.md)(status: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), emit: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Listen status for enable [OnBackPressedCallback](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedCallback.html)

#### Author

Vitaliy Zarubin

## Samples

[androidJvm]\
ru.surf.template.drawer.AppDrawer

## Parameters

androidJvm

| | |
|---|---|
| status | state enable handleOnBackPressed |
| emit | lambda for emit is enable |
