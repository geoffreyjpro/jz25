package com.example.jz25

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

}

actual fun getPlatform(): Platform = JVMPlatform()