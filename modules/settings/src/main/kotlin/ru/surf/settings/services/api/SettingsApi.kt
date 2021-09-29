/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.services.api

import ru.surf.core.services.api.impl.ApiDelete
import ru.surf.settings.services.api.impl.ApiGet
import ru.surf.settings.services.api.impl.ApiPatch
import ru.surf.settings.services.api.impl.ApiPost
import ru.surf.settings.services.api.impl.ApiPut

/**
 * Base interfaces for retrofit separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
interface SettingsApi : ApiDelete, ApiGet, ApiPatch, ApiPost, ApiPut
