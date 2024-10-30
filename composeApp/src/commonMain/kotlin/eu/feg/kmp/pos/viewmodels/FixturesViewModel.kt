package eu.feg.kmp.pos.viewmodels

import androidx.lifecycle.ViewModel
import repositories.FixturesRepository

class FixturesViewModel(
    private val repository: FixturesRepository,
    private val tournamentId: String,
) : ViewModel() {

    val fixtures = repository.fixtures

    init{
        repository.getFixtures(tournamentId)
    }
}
