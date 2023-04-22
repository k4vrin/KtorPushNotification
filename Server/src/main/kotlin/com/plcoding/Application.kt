package com.plcoding

import com.plcoding.data.remote.service.OneSignalServiceImpl
import io.ktor.application.*
import com.plcoding.plugins.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }

        install(Logging) {
            level = LogLevel.ALL
        }
    }

    val apiKey = System.getenv()["api_key"] ?: throw IllegalArgumentException("apiKey empty")


    val service = OneSignalServiceImpl(client = client, apiKey = apiKey)

    configureRouting(service)
}
