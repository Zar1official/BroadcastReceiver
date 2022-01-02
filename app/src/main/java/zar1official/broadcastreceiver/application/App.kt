package zar1official.broadcastreceiver.application

import android.app.Application
import zar1official.broadcastreceiver.data.storage.Storage


class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    lateinit var storage: Storage
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        storage = Storage.getStorage()
    }
}