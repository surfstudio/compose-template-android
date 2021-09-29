/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.services.dataService

import ru.surf.users.base.UsersDatabase
import ru.surf.users.services.dataService.impl.UserModelDataService

/**
 * Base service module for work with db room
 *
 * @author Vitaliy Zarubin
 */
class UsersDataService(
    override val db: UsersDatabase,
) : UserModelDataService
