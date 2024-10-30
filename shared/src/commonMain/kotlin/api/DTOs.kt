package api

import kotlinx.serialization.Serializable

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
    val id: String = "",
    val sportId: String = "",
    val name: String = "",
    val seoName: String = "",
    val icon: String = "",
    val order: Int = 0,
    val fixturesCount: Int = 0,
    val listUnderSport: Boolean = false,
    val filters: List<String> = listOf(),
    val features: List<String> = listOf(),
    val description: String? = null // Optional field, use default value as null
)

@Serializable
data class SportsData(
    val sport: Sport,
    val tournaments: List<Tournament>
)

data class Sports(val items: List<Sport> = emptyList())

@Serializable
data class FixturesData(
    val tournament: Tournament,
    val fixtures: List<Fixture>
)

@Serializable
data class Fixture(
    val id: String,
    val sportId: String,
    val tournamentId: String,
    val kind: String,
    val name: String,
    val seoName: String? = null,
    val order: Int,
    val participants: List<Participant>,
    val startDatetime: Long,
    val sportcastId: Int,
    val totalMarketCount: Int
)

@Serializable
data class Participant(
    val id: String,
    val name: String,
    val type: String,
    val icon: String? = null,
)