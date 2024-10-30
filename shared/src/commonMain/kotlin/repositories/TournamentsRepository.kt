package repositories

import api.NetworkModule
import api.Sport
import api.SportsData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TournamentsRepository() {
    private val context = Dispatchers.Main.immediate +
            SupervisorJob() +
            CoroutineExceptionHandler { _, _ -> }

    private val scope = CoroutineScope(context)

    private val _tournaments: MutableStateFlow<SportsData> = MutableStateFlow(SportsData(Sport(), emptyList()))

    val tournaments: Flow<SportsData> = _tournaments

    fun getTournaments(sportId: String) {
        println("getTournaments $sportId")
        try {
            scope.launch(Dispatchers.IO) {
                val res = NetworkModule.api.getTournaments(sportId)
                _tournaments.emit(res)
            }
        } catch (e: Exception) {
            println(e)
        }
    }

}