/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.ui.actions

// @todo {ScreenName}Actions
sealed class ListTemplateActions {
    class Search(val text: String?) : ListTemplateActions()
}
