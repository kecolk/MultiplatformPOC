package eu.feg.kmp.pos.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import kotlinx.serialization.Serializable

// Define a Composition Local for NavController
val LocalNavController = compositionLocalOf<NavController> {
    error("NavController not provided")
}

//Typed navigation parameters
@Serializable
data class TournamentsParams(val sportId: String, val name: String)

@Serializable
data class FixturesParams(val tournamentId: String, val name: String)
