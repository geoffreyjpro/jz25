package com.example.jz25

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val httpClient = HttpClient(Js) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

}

actual fun getPlatform(): Platform = WasmPlatform()