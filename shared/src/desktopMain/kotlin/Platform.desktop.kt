package eu.feg.kmp.poc.shared

import eu.feg.kmp.poc.shared.Platform

class DesktopPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = DesktopPlatform()