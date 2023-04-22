package com.plcoding.data.remote.service

import com.plcoding.data.remote.dto.Notification

interface OneSignalService {

    suspend fun sendNotification(notification: Notification): Boolean

    companion object {
        const val OneSignalAppId = "9578e7ef-4c23-4ce5-9250-f19191e57cb8"
        const val NotificationsUrl = "https://onesignal.com/api/v1/notifications"
    }

}