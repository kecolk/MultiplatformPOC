package eu.feg.kmp.pos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform