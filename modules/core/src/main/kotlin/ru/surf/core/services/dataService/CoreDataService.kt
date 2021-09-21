package ru.surf.core.services.dataService

import ru.surf.core.base.CoreDatabase
import ru.surf.core.base.CorePreferences
import ru.surf.core.base.CoreSecurityDatabase
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.core.services.dataService.impl.SettingsModelDataService
import ru.surf.core.services.dataService.impl.SecurityModelDataService

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