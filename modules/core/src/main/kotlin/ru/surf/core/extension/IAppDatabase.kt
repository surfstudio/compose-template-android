/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.extension

import androidx.room.withTransaction
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.interfaces.IAppDatabase

/**
 * Extensions for easy transaction
 *
 * @property body suspend lambda fun
 *
 * @author Vitaliy Zarubin
 */
@Suppress("UNCHECKED_CAST")
suspend fun <T> IAppDatabase.withTransaction(body: suspend T.() -> Unit) {
    db.withTransaction {
        body.invoke(this as T)
    }
}
