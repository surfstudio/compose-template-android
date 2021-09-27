/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.services.api

import ru.surf.core.services.api.impl.ApiDelete
import ru.surf.users.services.api.impl.ApiGet
import ru.surf.users.services.api.impl.ApiPatch
import ru.surf.users.services.api.impl.ApiPost
import ru.surf.users.services.api.impl.ApiPut

interface UsersApi : ApiDelete, ApiGet, ApiPatch, ApiPost, ApiPut
