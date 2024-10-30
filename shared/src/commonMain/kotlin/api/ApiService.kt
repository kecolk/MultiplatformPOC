package api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

interface ApiService {
    @GET("${BASE_URL}offer/structure/api/v1_0/prematch/sports?timeFilter=today")
    suspend fun getSports(): List<Sport>

    @GET("${BASE_URL}offer/structure/api/v1_0/prematch/sport/{sportId}/tournaments?timeFilter=today")
    suspend fun getTournaments(@Path sportId: String): SportsData

    @GET("${BASE_URL}offer/structure/api/v1_0/prematch/tournament/{tournamentId}/fixtures?marketFilterType=OVERVIEW&timeFilter=filter_default")
    suspend fun getFixtures(@Path tournamentId: String): FixturesData
}

const val BASE_URL = "https://api.ifortuna.cz/"