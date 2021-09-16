package ru.surf.users.services.dataService

import ru.surf.core.interfaces.IAppDatabase
import ru.surf.users.base.AppDatabase
import ru.surf.users.data.preferences.AppPreferences
import ru.surf.users.services.dataService.impl.UserModelDataService

class UsersDataService(
    override val db: AppDatabase,
    override val preferences: AppPreferences
) : IAppDatabase<UsersDataService>,
    UserModelDataService