package ru.surf.users.services.dataService.impl

import androidx.paging.PagingSource
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.dao.UserModelDao
import ru.surf.users.data.models.UserModel

interface UserModelDataService {

    val db: UsersDatabase

    private val dao: UserModelDao get() = db.daoUserModel()

    fun pagingListUserModel(): PagingSource<Int, UserModel> {
        return dao.pagingSource()
    }

    suspend fun insertUserModel(vararg models: UserModel) {
        dao.insertModels(*models)
    }

    suspend fun clearUserModel() {
        dao.clear()
    }

    suspend fun countUserModel(): Int {
        return dao.count()
    }
}