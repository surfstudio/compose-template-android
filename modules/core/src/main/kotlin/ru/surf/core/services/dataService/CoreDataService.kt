/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.dataService

import ru.surf.core.base.CoreDatabase
import ru.surf.core.base.CoreSecurityDatabase
import ru.surf.core.services.dataService.impl.SecurityModelDataService
import ru.surf.core.services.dataService.impl.SettingsModelDataService

/**
 * Base service module for work with db room
 *
 * @author Vitaliy Zarubin
 */
class CoreDataService(
    override val db: CoreDatabase,
    override val dbSecurity: CoreSecurityDatabase,
) : SecurityModelDataService,
    SettingsModelDataService {

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        super<SecurityModelDataService>.clearCacheAfterLogout()
        super<SettingsModelDataService>.clearCacheAfterLogout()
    }
}
