package org.example.fintrack

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform