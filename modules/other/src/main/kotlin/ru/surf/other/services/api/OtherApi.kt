/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.services.api

import ru.surf.core.services.api.impl.ApiDelete
import ru.surf.other.services.api.impl.ApiGet
import ru.surf.other.services.api.impl.ApiPatch
import ru.surf.other.services.api.impl.ApiPost
import ru.surf.other.services.api.impl.ApiPut

interface OtherApi : ApiDelete, ApiGet, ApiPatch, ApiPost, ApiPut
