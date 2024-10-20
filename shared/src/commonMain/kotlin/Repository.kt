package eu.feg.kmp.poc.shared

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class Repository() {
    private val context = Dispatchers.Main.immediate +
        SupervisorJob() +
        CoroutineExceptionHandler { _, throwable ->
//                            _failure.tryEmit(throwable)
        }

    private val scope = CoroutineScope(context)

    private val _data = MutableStateFlow<Int>(0)
    val data: Flow<Int> get() = _data

    private val _sports: MutableStateFlow<SportEvents> = MutableStateFlow(SportEvents())

    val sports: Flow<SportEvents> = _sports

    private var sportsRequested: Boolean = false


    init {
        startGenerator()
    }

    private fun startGenerator() {
        scope.launch(Dispatchers.Default) {
            while (true) {
                val score = Random.nextInt(6) + 1
                if (score == 6 && !sportsRequested) getSports()
                _data.emit(score)
                delay(2000)
                if (sportsRequested) break
            }
        }
    }

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