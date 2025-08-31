package com.example.jz25

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello JZ, ${platform.name}!"
    }

    suspend fun sayHelloFromChuck(): ChuckNorris {
        return platform.httpClient.get("https://api.chucknorris.io/jokes/random?category=dev").body<ChuckNorris>()
    }

}

@Serializable
data class ChuckNorris(
    val id: String,
    val value:String,
)
