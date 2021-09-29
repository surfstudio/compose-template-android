//[settings](../../index.md)/[ru.surf.settings.ui.screens.settings](index.md)

# Package ru.surf.settings.ui.screens.settings

## Functions

| Name | Summary |
|---|---|
| [Preview](-preview.md) | [androidJvm]<br>@Preview(uiMode = 16, device = "id:pixel_4")<br>@Preview(uiMode = 32, device = "id:Nexus 6")<br>@Composable<br>private fun [Preview](-preview.md)() |
| [SettingsBody](-settings-body.md) | [androidJvm]<br>@Composable<br>fun [SettingsBody](-settings-body.md)(loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, onActions: ([SettingsActions](../ru.surf.settings.ui.actions/-settings-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Body page [SettingsScreen](-settings-screen.md) |
| [SettingsItem](-settings-item.md) | [androidJvm]<br>@Composable<br>fun [SettingsItem](-settings-item.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Item list for page [SettingsBody](-settings-body.md) |
| [SettingsScreen](-settings-screen.md) | [androidJvm]<br>@Composable<br>fun [SettingsScreen](-settings-screen.md)(viewModel: [SettingsViewModel](../ru.surf.settings.ui.viewModels/-settings-view-model/index.md), onActions: ([SettingsActions](../ru.surf.settings.ui.actions/-settings-actions/index.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Base page fun for initialization |
| [SettingsSwitch](-settings-switch.md) | [androidJvm]<br>@Composable<br>fun [SettingsSwitch](-settings-switch.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), checked: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, onCheckedChange: ([Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Item list for page [SettingsBody](-settings-body.md) |
