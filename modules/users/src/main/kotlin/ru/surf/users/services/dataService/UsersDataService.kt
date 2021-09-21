package ru.surf.users.services.dataService

import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.dataService.impl.UserModelDataService

class UsersDataService(
    override val db: UsersDatabase,
) : UserModelDataService