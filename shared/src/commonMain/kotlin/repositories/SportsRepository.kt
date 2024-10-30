package repositories

import api.NetworkModule
import api.Sports
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class SportsRepository() {
    private val context = Dispatchers.Main.immediate +
        SupervisorJob() +
        CoroutineExceptionHandler { _, _ -> }

    private val scope = CoroutineScope(context)

    private val _sports: MutableStateFlow<Sports> = MutableStateFlow(Sports())

    val sports: Flow<Sports> = _sports

    private var sportsRequested: Boolean = false

    fun getSports() {
        println("getSport")
        scope.launch(Dispatchers.IO) {
            sportsRequested = true
            try {
                val res = NetworkModule.api.getSports()
                _sports.emit(Sports(res))
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}