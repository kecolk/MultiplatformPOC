package eu.feg.kmp.poc.shared

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

interface ApiService {
    @GET("https://api.ifortuna.cz/offer/structure/api/v1_0/prematch/sports?timeFilter=today")
    suspend fun getSports(): List<SportEvent>

    @GET("https://api.ifortuna.cz/offer/structure/api/v1_0/prematch/sport/{sportId}/tournaments?timeFilter=today")
    suspend fun getTournaments(@Path sportId: String): SportsData

}
