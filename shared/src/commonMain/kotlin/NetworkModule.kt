package eu.feg.kmp.poc.shared

import de.jensklingenberg.ktorfit.Ktorfit
import ktorClient

object NetworkModule {
    private val ktorfit = Ktorfit.Builder().httpClient(ktorClient).build()

    val api: ApiService by lazy {
        ktorfit.createApiService()
    }
}
