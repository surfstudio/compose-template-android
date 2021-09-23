package ru.surf.settings.services.api

import ru.surf.core.services.api.impl.ApiDelete
import ru.surf.settings.services.api.impl.*

interface SettingsApi : ApiDelete, ApiGet, ApiPatch, ApiPost, ApiPut