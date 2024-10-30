package eu.feg.kmp.pos

import androidx.lifecycle.ViewModel
import eu.feg.kmp.poc.shared.FixturesRepository

class FixturesViewModel(
    private val repository: FixturesRepository,
    private val tournamentId: String,
) : ViewModel() {

    val fixtures = repository.fixtures

    init{
        repository.getFixtures(tournamentId)
    }
}
