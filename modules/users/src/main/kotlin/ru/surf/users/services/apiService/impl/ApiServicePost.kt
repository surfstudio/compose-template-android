package ru.surf.users.services.apiService.impl

import io.ktor.client.*

interface ApiServicePost {
    val httpClient: HttpClient
}