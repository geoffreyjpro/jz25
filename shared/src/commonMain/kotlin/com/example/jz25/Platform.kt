package com.example.jz25

import io.ktor.client.HttpClient

interface Platform {
    val name: String
    val httpClient: HttpClient
}

expect fun getPlatform(): Platform