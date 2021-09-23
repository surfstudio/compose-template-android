package ru.surf.core.services.dataService

import ru.surf.core.base.CoreDatabase
import ru.surf.core.base.CoreSecurityDatabase
import ru.surf.core.services.dataService.impl.SecurityModelDataService
import ru.surf.core.services.dataService.impl.SettingsModelDataService

class CoreDataService(
    override val db: CoreDatabase,
    override val dbSecurity: CoreSecurityDatabase,
) : SecurityModelDataService,
    SettingsModelDataService {

    override fun clearCacheAfterLogout() {
        super<SecurityModelDataService>.clearCacheAfterLogout()
        super<SettingsModelDataService>.clearCacheAfterLogout()
    }
}