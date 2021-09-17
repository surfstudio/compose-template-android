package ru.surf.template.ui.actions

// @todo {ScreenName}Actions
sealed class ListTemplateActions {
    class Search(val text: String?) : ListTemplateActions()
}