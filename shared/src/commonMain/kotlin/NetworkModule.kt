package eu.feg.kmp.poc.shared

import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.serialization.json.Json

object NetworkModule {
    private val ktorClient = HttpClient() {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true            }
            )
        }
    }

    private val ktorfit = Ktorfit.Builder().httpClient(ktorClient).build()


    val api: ApiService by lazy {
        ktorfit.createApiService()
    }
}
