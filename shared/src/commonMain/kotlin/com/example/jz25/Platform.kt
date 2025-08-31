package com.example.jz25

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform