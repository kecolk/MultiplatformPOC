package repositories

import api.FixturesData
import api.NetworkModule
import api.Tournament
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FixturesRepository {
    private val context = Dispatchers.Main.immediate +
            SupervisorJob() +
            CoroutineExceptionHandler { _, _ -> }

    private val scope = CoroutineScope(context)

    private val _fixtures: MutableStateFlow<FixturesData> = MutableStateFlow(FixturesData(Tournament(), emptyList()))

    val fixtures: Flow<FixturesData> = _fixtures

    fun getFixtures(tournamentId: String) {
        println("getFixtures $tournamentId")
        try {
            scope.launch(Dispatchers.IO) {
                val res = NetworkModule.api.getFixtures(tournamentId)
                _fixtures.emit(res)
            }
        } catch (e: Exception) {
            println(e)
        }
    }

}