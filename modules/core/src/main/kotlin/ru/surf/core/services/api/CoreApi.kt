/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.api

import ru.surf.core.services.api.impl.*

/**
 * Base interfaces for retrofit separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
interface CoreApi : ApiDelete, ApiGet, ApiPatch, ApiPost, ApiPut
