package ru.surf.template.services.dataService.impl

import androidx.paging.PagingSource
import ru.surf.template.base.TemplateDatabase
import ru.surf.template.data.dao.TemplateModelDao
import ru.surf.template.data.models.TemplateModel

// @todo {ModuleName}Database
// @todo {ModelName}DataService
// @todo {ModelName}DataService
interface TemplateModelDataService {

    val db: TemplateDatabase

    private val dao: TemplateModelDao get() = db.templateModelDao()

    // @todo pagingList{ModelName}Model
    fun pagingListTemplateModel(): PagingSource<Int, TemplateModel> {
        return dao.pagingSource()
    }

    // @todo pagingList{ModelName}Model
    suspend fun insertTemplateModel(vararg models: TemplateModel) {
        dao.insertModels(*models)
    }

    // @todo pagingList{ModelName}Model
    suspend fun clearTemplateModel() {
        dao.clear()
    }

    // @todo pagingList{ModelName}Model
    suspend fun countTemplateModel(): Int {
        return dao.count()
    }
}