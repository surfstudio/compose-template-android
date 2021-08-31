package ru.surf.users.services.dataService

import ru.surf.users.base.AppDatabase
import ru.surf.users.base.BaseDataService
import ru.surf.users.base.preferences.AppPreferences
import ru.surf.users.services.dataService.impl.UserModelDataService

class UsersDataService(
    override val db: AppDatabase,
    override val preferences: AppPreferences
) : BaseDataService<UsersDataService>,
    UserModelDataService