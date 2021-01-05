package io.schnellgif.repositories

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.ContentType
import kotlinx.serialization.json.Json

internal val client = HttpClient(CIO) {
    install(JsonFeature) {
        acceptContentTypes =
            listOf(ContentType("application", "json"), ContentType("text", "html"))

        serializer = KotlinxSerializer( Json {
            isLenient = false
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = false
        })
    }
}
