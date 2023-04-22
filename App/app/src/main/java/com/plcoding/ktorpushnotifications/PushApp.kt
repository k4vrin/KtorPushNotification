package com.plcoding.ktorpushnotifications

import android.app.Application
import com.onesignal.OneSignal

class PushApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(OneSignalAppId)
    }

    companion object {
        const val OneSignalAppId = "9578e7ef-4c23-4ce5-9250-f19191e57cb8"
    }
}