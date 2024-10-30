package eu.feg.kmp.pos

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import eu.feg.kmp.pos.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MultiplatfomPOC",
    ) {
        App()
    }
}