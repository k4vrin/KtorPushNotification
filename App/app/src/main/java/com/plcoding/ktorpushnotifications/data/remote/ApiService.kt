package com.plcoding.ktorpushnotifications.data.remote

interface ApiService {
    suspend fun sendNotification(title: String, description: String)

    companion object {
        // Emulator
        const val SendNotificationUrl = "http://10.0.2.2:8080/sendNotification"

        // Real Device
        // terminal -> ipconfig -> adapter -> IPv4 Address
        // terminal -> ifconfig -> adapter -> IPv4 Address
//        const val SendNotificationUrl = "http://192.168.43.142:8080"
    }
}