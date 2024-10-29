package eu.feg.kmp.pos

import KoinInitializer
import android.app.Application

class PocApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KoinInitializer(applicationContext).init()
    }
}
