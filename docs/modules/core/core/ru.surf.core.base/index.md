//[core](../../index.md)/[ru.surf.core.base](index.md)

# Package ru.surf.core.base

## Types

| Name | Summary |
|---|---|
| [ColorsCustom](-colors-custom/index.md) | [androidJvm]<br>class [ColorsCustom](-colors-custom/index.md)(link: Color, linkAction: Color, isLight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Custom colors for own theme [MaterialThemeCustom](-material-theme-custom/index.md) |
| [CoreDatabase](-core-database/index.md) | [androidJvm]<br>abstract class [CoreDatabase](-core-database/index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)<br>Database configuration [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html) |
| [CoreDatabaseQualifier](-core-database-qualifier/index.md) | [androidJvm]<br>@Qualifier<br>annotation class [CoreDatabaseQualifier](-core-database-qualifier/index.md)<br>For database that doesn't need migrations and encryption |
| [CoreDatabaseSecurityQualifier](-core-database-security-qualifier/index.md) | [androidJvm]<br>@Qualifier<br>annotation class [CoreDatabaseSecurityQualifier](-core-database-security-qualifier/index.md)<br>For database with encryption and migrations |
| [CoreSecurityDatabase](-core-security-database/index.md) | [androidJvm]<br>abstract class [CoreSecurityDatabase](-core-security-database/index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)<br>Database configuration [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html) |
| [LocalMaterialThemeCustom](-local-material-theme-custom/index.md) | [androidJvm]<br>object [LocalMaterialThemeCustom](-local-material-theme-custom/index.md)<br>Static object for [MaterialThemeCustom](-material-theme-custom/index.md) |
| [MainViewModel](-main-view-model/index.md) | [androidJvm]<br>class [MainViewModel](-main-view-model/index.md)@Injectconstructor(apiService: [CoreApiService](../ru.surf.core.services.apiService/-core-api-service/index.md), dataService: [CoreDataService](../ru.surf.core.services.dataService/-core-data-service/index.md), dataServices: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppDatabase](../ru.surf.core.interfaces/-i-app-database/index.md)&gt;, preferences: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;@[JvmSuppressWildcards](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html)[IAppPreferences](../ru.surf.core.interfaces/-i-app-preferences/index.md)&gt;) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>Main [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) for app |
| [MaterialThemeCustom](-material-theme-custom/index.md) | [androidJvm]<br>object [MaterialThemeCustom](-material-theme-custom/index.md)<br>Material Theme Custom |
| [ShapesCustom](-shapes-custom/index.md) | [androidJvm]<br>class [ShapesCustom](-shapes-custom/index.md)(listItem: CornerBasedShape)<br>Shapes custom for [MaterialThemeCustom](-material-theme-custom/index.md) |
| [TryExecuteWithResponse](-try-execute-with-response/index.md) | [androidJvm]<br>class [TryExecuteWithResponse](-try-execute-with-response/index.md)<br>Observe for specific exceptions |
| [TypographyCustom](-typography-custom/index.md) | [androidJvm]<br>class [TypographyCustom](-typography-custom/index.md)(title: TextStyle)<br>Typography custom for [MaterialThemeCustom](-material-theme-custom/index.md) |

## Functions

| Name | Summary |
|---|---|
| [MaterialThemeCustom](-material-theme-custom.md) | [androidJvm]<br>@Composable<br>fun [MaterialThemeCustom](-material-theme-custom.md)(colors: [ColorsCustom](-colors-custom/index.md) = LocalMaterialThemeCustom.colors!!, typography: [TypographyCustom](-typography-custom/index.md) = TypographyCustom.default.invoke(), shapes: [ShapesCustom](-shapes-custom/index.md) = ShapesCustom.default)<br>fun for generate [MaterialThemeCustom](-material-theme-custom/index.md) |

## Properties

| Name | Summary |
|---|---|
| [LocalBackPressedDispatcher](-local-back-pressed-dispatcher.md) | [androidJvm]<br>val [LocalBackPressedDispatcher](-local-back-pressed-dispatcher.md): ProvidableCompositionLocal&lt;[OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html)&gt;<br>[OnBackPressedDispatcher](https://developer.android.com/reference/kotlin/androidx/activity/OnBackPressedDispatcher.html) Can be used in CompositionLocalProvider to provide values. |
| [LocalMainViewModel](-local-main-view-model.md) | [androidJvm]<br>val [LocalMainViewModel](-local-main-view-model.md): ProvidableCompositionLocal&lt;[MainViewModel](-main-view-model/index.md)&gt;<br>[MainViewModel](-main-view-model/index.md) Can be used in CompositionLocalProvider to provide values. |
