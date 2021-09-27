/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.extension

import androidx.room.withTransaction
import ru.surf.core.interfaces.IAppDatabase

@Suppress("UNCHECKED_CAST")
suspend fun <T> IAppDatabase.withTransaction(body: suspend T.() -> Unit) {
    db.withTransaction {
        body.invoke(this as T)
    }
}
