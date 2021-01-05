package io.schnellgif

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.serialization.json
import io.schnellgif.repositories.GifRepositoryImpl
import io.schnellgif.repositories.client
import io.schnellgif.viewmodels.GifListViewModel
import kotlinx.serialization.json.Json

private fun Application.init(main: () -> Unit) {
    install(DefaultHeaders)
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = false
        })
    }
    main()
}

fun Application.main() {
    init {
        val vm = GifListViewModel(GifRepositoryImpl(client))
        routing {
            get("/") {
                call.respond(
                    HttpStatusCode.OK,
                    vm.getGifList(),
                )
            }
        }
    }
}


