package ru.surf.users.services.dataService.impl

import androidx.paging.PagingSource
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.dao.UserModelDao
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.dataService.UsersDataService
import timber.log.Timber

interface UserModelDataService: IAppDatabase {

    override val db: UsersDatabase

    private val dao: UserModelDao get() = db.daoUserModel()

    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: UserModelDataService")
    }

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