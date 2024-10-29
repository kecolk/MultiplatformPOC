import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

actual val ktorClient = HttpClient(Android) {
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
            ignoreUnknownKeys = true
        }
        )
    }
}
