package eu.feg.kmp.poc.shared

import eu.feg.kmp.poc.shared.Platform

class DesktopPlatform : Platform {
    override val name: String = "Desktop"
}

actual fun getPlatform(): Platform = DesktopPlatform()