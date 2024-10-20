package eu.feg.kmp.pos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MultiplatfomPOC",
    ) {
        App()
    }
}