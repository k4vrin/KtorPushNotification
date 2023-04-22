package com.plcoding.ktorpushnotifications.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {
    override suspend fun sendNotification(title: String, description: String) {
        try {
            client.get<String> {
                url(ApiService.SendNotificationUrl)
                parameter("title", title)
                parameter("description", description)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}