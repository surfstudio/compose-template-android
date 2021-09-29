//[app](../../../index.md)/[ru.surf.template](../index.md)/[AppActivity](index.md)

# AppActivity

[androidJvm]\
class [AppActivity](index.md) : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html)

This is the main and only Activity

#### Author

Vitaliy Zarubin

## Constructors

| | |
|---|---|
| [AppActivity](-app-activity.md) | [androidJvm]<br>fun [AppActivity](-app-activity.md)() |

## Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | [androidJvm]<br>protected open override fun [onCreate](on-create.md)(savedInstanceState: [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html)?)<br>Main initialization point of view |

## Properties

| Name | Summary |
|---|---|
| [viewModel](view-model.md) | [androidJvm]<br>private val [viewModel](view-model.md): [MainViewModel](../../../../modules/core/core/ru.surf.core.base/-main-view-model/index.md)<br>Main ViewModel which is available throughout the application as staticCompositionLocalOf |
