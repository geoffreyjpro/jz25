package com.example.jz25

import android.os.Build
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class AndroidPlatform : Platform {
    override val name: String = "Android SDK ${Build.VERSION.SDK_INT}"
    override val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

}

actual fun getPlatform(): Platform = AndroidPlatform()