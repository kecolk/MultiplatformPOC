package eu.feg.kmp.pos

import eu.feg.kmp.poc.shared.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}