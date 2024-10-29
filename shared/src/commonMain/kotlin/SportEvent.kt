package eu.feg.kmp.poc.shared

import kotlinx.serialization.Serializable

@Serializable
data class SportEvent(
    val id: String,
    val name: String,
    val seoName: String,
    val icon: String,
    val type: String,
    val order: Int,
    val fixturesCount: Int,
    val filters: List<String>
)

@Serializable
data class Sport(
    val id: String = "",
    val name: String = "",
    val seoName: String = "",
    val icon: String = "",
    val type: String = "",
    val order: Int = 0,
    val fixturesCount: Int = 0,
    val filters: List<String> = emptyList(),
)

@Serializable
data class Tournament(
    val id: String,
    val sportId: String,
    val name: String,
    val seoName: String,
    val icon: String,
    val order: Int,
    val fixturesCount: Int,
    val listUnderSport: Boolean,
    val filters: List<String>,
    val features: List<String>,
    val description: String? = null // Optional field, use default value as null
)

@Serializable
data class SportsData(
    val sport:  Sport,
    val tournaments: List<Tournament>
)

data class SportEvents(val items: List<SportEvent> = emptyList())

@Serializable
data class TournamentsParams(val sportId: String)