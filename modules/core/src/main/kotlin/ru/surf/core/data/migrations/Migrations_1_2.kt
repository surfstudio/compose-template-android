package ru.surf.core.data.migrations

import androidx.room.migration.*
import androidx.sqlite.db.*

val Migrations_1_2 = object : Migration(1, 2) {

    val TABLE_NAME = "SecurityModel"

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE `${TABLE_NAME}` ADD COLUMN `token` TEXT NOT NULL DEFAULT ''")
    }
}