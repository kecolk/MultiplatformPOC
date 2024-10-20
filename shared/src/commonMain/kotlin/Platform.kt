package eu.feg.kmp.poc.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform