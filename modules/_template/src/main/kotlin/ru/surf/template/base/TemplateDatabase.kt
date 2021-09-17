package ru.surf.template.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.template.data.dao.TemplateModelDao
import ru.surf.template.data.models.TemplateModel

@Database(
    entities = [
        // @todo {ModelName}Model
        TemplateModel::class,
    ],
    version = 1,
    exportSchema = false
)
// @todo {ModuleName}Database
abstract class TemplateDatabase : RoomDatabase() {
    // @todo {ModelName}ModelDao
    abstract fun templateModelDao(): TemplateModelDao
}