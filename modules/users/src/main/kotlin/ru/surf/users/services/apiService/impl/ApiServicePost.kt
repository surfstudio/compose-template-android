/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.services.apiService.impl

import ru.surf.users.services.api.UsersApi

/**
 * The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServicePost {
    val api: UsersApi
}
