package eu.feg.kmp.poc.shared

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android API ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()