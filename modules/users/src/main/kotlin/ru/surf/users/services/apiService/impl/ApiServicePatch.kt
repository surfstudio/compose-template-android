package ru.surf.users.services.apiService.impl

import io.ktor.client.*

interface ApiServicePatch {
    val httpClient: HttpClient
}