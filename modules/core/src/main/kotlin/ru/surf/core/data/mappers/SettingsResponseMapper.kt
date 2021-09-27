/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.data.mappers

import ru.surf.core.data.models.SettingsModel
import ru.surf.core.data.responses.SettingsResponse

fun SettingsResponse.toModel(): SettingsModel {
    return SettingsModel(
        id = key,
        value = value,
    )
}

fun List<SettingsResponse>.toModels(): List<SettingsModel> {
    return map { it.toModel() }
}
