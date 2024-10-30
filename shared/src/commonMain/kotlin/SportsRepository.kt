package eu.feg.kmp.poc.shared

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class SportsRepository() {
    private val context = Dispatchers.Main.immediate +
        SupervisorJob() +
        CoroutineExceptionHandler { _, throwable ->
//                            _failure.tryEmit(throwable)
        }

    private val scope = CoroutineScope(context)

    private val _sports: MutableStateFlow<SportEvents> = MutableStateFlow(SportEvents())

    val sports: Flow<SportEvents> = _sports

    private var sportsRequested: Boolean = false

    fun getSports() {
        println("getSport")
        scope.launch(Dispatchers.IO) {
            sportsRequested = true
            try {
                val res = NetworkModule.api.getSports()
                _sports.emit(SportEvents(res))
            } catch (e: Exception) {
                println(e)
            }
        }
    }

}