package eu.feg.kmp.pos

import android.app.Application
import eu.feg.kmp.poc.shared.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PocApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PocApplication)
            androidLogger()
            modules(sharedModule)
        }
    }
}
